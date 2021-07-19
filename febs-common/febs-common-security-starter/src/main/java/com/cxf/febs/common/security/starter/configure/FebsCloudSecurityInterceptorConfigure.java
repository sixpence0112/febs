package com.cxf.febs.common.security.starter.configure;

import com.cxf.febs.common.security.starter.interceptor.FebsServerProtectInterceptor;
import com.cxf.febs.common.security.starter.properties.FebsCloudSecurityProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author sixpence
 * @version 1.0 2021/7/19
 */
public class FebsCloudSecurityInterceptorConfigure implements WebMvcConfigurer {

    private FebsCloudSecurityProperties properties;

    @Autowired
    public void setProperties(FebsCloudSecurityProperties properties) {
        this.properties = properties;
    }

    @Bean
    public HandlerInterceptor febsServerProtectInterceptor() {
        FebsServerProtectInterceptor febsServerProtectInterceptor = new FebsServerProtectInterceptor();
        febsServerProtectInterceptor.setProperties(properties);
        return febsServerProtectInterceptor;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(febsServerProtectInterceptor());
    }
}
