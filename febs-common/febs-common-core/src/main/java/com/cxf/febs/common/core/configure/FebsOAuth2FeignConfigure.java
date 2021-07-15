package com.cxf.febs.common.core.configure;

import com.cxf.febs.common.core.entity.constant.FebsConstant;
import feign.RequestInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpHeaders;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.provider.authentication.OAuth2AuthenticationDetails;
import org.springframework.util.Base64Utils;

/**
 * 获取令牌，并添加进requestTemplate请求头
 *
 * @author sixpence
 * @version 1.0 2020/9/30
 */
public class FebsOAuth2FeignConfigure {

    @Bean
    public RequestInterceptor oauth2FeignRequestInterceptor() {
        return requestTemplate -> {
            // 请求头中添加 Gateway Token
            String zuulToken = new String(Base64Utils.encode(FebsConstant.GATEWAY_TOKEN_VALUE.getBytes()));
            requestTemplate.header(FebsConstant.GATEWAY_TOKEN_HEADER, zuulToken);
            // 请求头中添加原请求头中的 Token
            Object details = SecurityContextHolder.getContext().getAuthentication().getDetails();
            if (details instanceof OAuth2AuthenticationDetails) {
                String authorizationToken = ((OAuth2AuthenticationDetails) details).getTokenValue();
                requestTemplate.header(HttpHeaders.AUTHORIZATION, FebsConstant.OAUTH2_TOKEN_TYPE + authorizationToken);
            }
        };
    }
}
