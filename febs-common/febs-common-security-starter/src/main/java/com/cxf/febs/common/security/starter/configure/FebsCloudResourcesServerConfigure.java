package com.cxf.febs.common.security.starter.configure;

import com.cxf.febs.common.core.entity.constant.EndpointConstant;
import com.cxf.febs.common.core.entity.constant.StringConstant;
import com.cxf.febs.common.security.starter.handler.FebsAccessDeniedHandler;
import com.cxf.febs.common.security.starter.handler.FebsAuthExceptionEntryPoint;
import com.cxf.febs.common.security.starter.properties.FebsCloudSecurityProperties;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.security.servlet.UserDetailsServiceAutoConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;

/**
 * @author sixpence
 * @version 1.0 2021/7/16
 */
@EnableResourceServer
@EnableAutoConfiguration(exclude = UserDetailsServiceAutoConfiguration.class)
public class FebsCloudResourcesServerConfigure extends ResourceServerConfigurerAdapter {

    private FebsCloudSecurityProperties properties;
    private FebsAccessDeniedHandler accessDeniedHandler;
    private FebsAuthExceptionEntryPoint exceptionEntryPoint;

    @Autowired(required = false)
    public void setProperties(FebsCloudSecurityProperties properties) {
        this.properties = properties;
    }

    @Autowired(required = false)
    public void setAccessDeniedHandler(FebsAccessDeniedHandler accessDeniedHandler) {
        this.accessDeniedHandler = accessDeniedHandler;
    }

    @Autowired(required = false)
    public void setExceptionEntryPoint(FebsAuthExceptionEntryPoint exceptionEntryPoint) {
        this.exceptionEntryPoint = exceptionEntryPoint;
    }

    @Override
    public void configure(HttpSecurity http) throws Exception {
        if (properties == null) {
            permitAll(http);
            return;
        }
        String[] anonUrls = StringUtils.splitByWholeSeparatorPreserveAllTokens(properties.getAnonUris(), StringConstant.COMMA);
        if (ArrayUtils.isEmpty(anonUrls)) {
            anonUrls = new String[]{};
        }
        if (ArrayUtils.contains(anonUrls, EndpointConstant.ALL)) {
            permitAll(http);
            return;
        }
        http.csrf().disable()
                .requestMatchers().antMatchers(properties.getAuthUri())
                .and()
                .authorizeRequests()
                .antMatchers(anonUrls).permitAll()
                .antMatchers(properties.getAuthUri()).permitAll()
                .and()
                .httpBasic();
    }

    @Override
    public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
        if (exceptionEntryPoint != null) {
            resources.authenticationEntryPoint(exceptionEntryPoint);
        }
        if (accessDeniedHandler != null) {
            resources.accessDeniedHandler(accessDeniedHandler);
        }
    }

    private void permitAll(HttpSecurity http) throws Exception {
        http.csrf().disable();
        http.authorizeRequests().anyRequest().permitAll();
    }
}
