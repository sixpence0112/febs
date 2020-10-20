package com.cxf.febs.server.test.configure;

import com.cxf.febs.common.handler.FebsAccessDeniedHandler;
import com.cxf.febs.common.handler.FebsAuthExceptionEntryPoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;

/**
 * @author sixpence
 * @version 1.0 2020/9/21
 */
@Configuration
@EnableResourceServer
public class FebsServerTestResourceServerConfigure extends ResourceServerConfigurerAdapter {

    @Autowired
    private FebsAccessDeniedHandler accessDeniedHandler;
    @Autowired
    private FebsAuthExceptionEntryPoint authExceptionEntryPoint;

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .requestMatchers().antMatchers("/**")
            .and()
                .authorizeRequests()
                .antMatchers("/**").authenticated()
                .antMatchers("/actuator/**").permitAll();
    }

    @Override
    public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
        resources.accessDeniedHandler(accessDeniedHandler)
                .authenticationEntryPoint(authExceptionEntryPoint);
    }
}
