package com.cxf.febs.auth.configure;

import com.cxf.febs.auth.filter.ValidateCodeFilter;
import com.cxf.febs.auth.service.impl.FebsUserDetailService;
import com.cxf.febs.common.core.entity.constant.EndpointConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/**
 * @author sixpence
 * @version 1.0 2020/9/17
 */
@Order(2)
@EnableWebSecurity
public class FebsSecurityConfigure extends WebSecurityConfigurerAdapter {

    @Autowired
    private FebsUserDetailService userDetailService;

    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private ValidateCodeFilter validateCodeFilter;

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.addFilterBefore(validateCodeFilter, UsernamePasswordAuthenticationFilter.class)
                .requestMatchers()
                //FebsSecurityConfigure安全配置类只对/oauth/开头的请求有效
                .antMatchers(EndpointConstant.OAUTH_ALL)
                .and()
                .authorizeRequests()
                .antMatchers(EndpointConstant.OAUTH_ALL).authenticated()
//                .and()
//                .authorizeRequests().antMatchers("/actuator/**").permitAll()
                .and()
                .csrf().disable();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailService).passwordEncoder(passwordEncoder);
    }
}
