package com.cxf.febs.common.security.starter.configure;

import com.cxf.febs.common.core.entity.constant.FebsConstant;
import com.cxf.febs.common.core.utils.FebsUtil;
import com.cxf.febs.common.security.starter.handler.FebsAccessDeniedHandler;
import com.cxf.febs.common.security.starter.handler.FebsAuthExceptionEntryPoint;
import com.cxf.febs.common.security.starter.properties.FebsCloudSecurityProperties;
import feign.RequestInterceptor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.autoconfigure.security.oauth2.resource.ResourceServerProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.http.HttpHeaders;
import org.springframework.security.access.expression.method.MethodSecurityExpressionHandler;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.method.configuration.GlobalMethodSecurityConfiguration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.provider.expression.OAuth2MethodSecurityExpressionHandler;
import org.springframework.security.oauth2.provider.token.DefaultTokenServices;
import org.springframework.util.Base64Utils;


/**
 * @author sixpence
 * @version 1.0 2021/7/19
 */
@EnableGlobalMethodSecurity(prePostEnabled = true)
@EnableConfigurationProperties(FebsCloudSecurityProperties.class)
@ConditionalOnProperty(value = "febs.cloud.security.enable", havingValue = "true", matchIfMissing = true)
public class FebsCloudSecurityAutoConfigure extends GlobalMethodSecurityConfiguration {
    @Bean
    @ConditionalOnMissingBean(name = "accessDeniedHandler")
    public FebsAccessDeniedHandler accessDeniedHandler() {
        return new FebsAccessDeniedHandler();
    }

    @Bean
    @ConditionalOnMissingBean(name = "authenticationEntryPoint")
    public FebsAuthExceptionEntryPoint authenticationEntryPoint() {
        return new FebsAuthExceptionEntryPoint();
    }

    @Bean
    @ConditionalOnMissingBean(value = PasswordEncoder.class)
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public FebsCloudSecurityInterceptorConfigure febsCloudSecurityInterceptorConfigure() {
        return new FebsCloudSecurityInterceptorConfigure();
    }

/*    @Bean
    @Primary
    @ConditionalOnMissingBean(DefaultTokenServices.class)
    public FebsUserInfoTokenServices febsUserInfoTokenServices(ResourceServerProperties properties) {
        return new FebsUserInfoTokenServices(properties.getUserInfoUri(), properties.getClientId());
    }*/

    @Bean
    public RequestInterceptor oauth2FeignRequestInterceptor() {
        return requestTemplate -> {
            String gatewayToken = new String(Base64Utils.encode(FebsConstant.GATEWAY_TOKEN_VALUE.getBytes()));
            requestTemplate.header(FebsConstant.GATEWAY_TOKEN_HEADER, gatewayToken);
            String authorizationToken = FebsUtil.getCurrentTokenValue();
            if (StringUtils.isNotBlank(authorizationToken)) {
                requestTemplate.header(HttpHeaders.AUTHORIZATION, FebsConstant.OAUTH2_TOKEN_TYPE + authorizationToken);
            }
        };
    }

    @Override
    protected MethodSecurityExpressionHandler createExpressionHandler() {
        return new OAuth2MethodSecurityExpressionHandler();
    }
}
