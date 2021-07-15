package com.cxf.febs.auth.filter;

import com.cxf.febs.auth.service.impl.ValidateCodeServiceImpl;
import com.cxf.febs.common.core.entity.FebsResponse;
import com.cxf.febs.common.core.entity.constant.EndpointConstant;
import com.cxf.febs.common.core.entity.constant.GrantTypeConstant;
import com.cxf.febs.common.core.entity.constant.ParamsConstant;
import com.cxf.febs.common.core.exception.ValidateCodeException;
import com.cxf.febs.common.core.utils.FebsUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.security.web.util.matcher.RequestMatcher;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.annotation.Nonnull;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

/**
 * 验证码过滤器
 *
 * @author sixpence
 * @version 1.0 2020/10/10
 */
@Slf4j
@Component
public class ValidateCodeFilter extends OncePerRequestFilter {

    @Autowired
    private ValidateCodeServiceImpl validateCodeService;

    @Override
    protected void doFilterInternal(@Nonnull HttpServletRequest httpServletRequest, @Nonnull HttpServletResponse httpServletResponse, @Nonnull FilterChain filterChain) throws ServletException, IOException {
        String header = httpServletRequest.getHeader(HttpHeaders.AUTHORIZATION);
        String clientId = getClientId(header, httpServletRequest);

        RequestMatcher matcher = new AntPathRequestMatcher(EndpointConstant.OAUTH_TOKEN, HttpMethod.POST.toString());
        if (matcher.matches(httpServletRequest)
                && StringUtils.equalsIgnoreCase(httpServletRequest.getParameter(ParamsConstant.GRANT_TYPE), GrantTypeConstant.PASSWORD)
                && !StringUtils.equalsAnyIgnoreCase(clientId, "swagger")) {
            try {
                validateCode(httpServletRequest);
                filterChain.doFilter(httpServletRequest, httpServletResponse);
            } catch (ValidateCodeException e) {
                FebsResponse febsResponse = new FebsResponse();
                FebsUtil.makeResponse(httpServletResponse, MediaType.APPLICATION_JSON_VALUE,
                        HttpServletResponse.SC_INTERNAL_SERVER_ERROR, febsResponse.message(e.getMessage()));
                log.error(e.getMessage(), e);
            }
        } else {
            filterChain.doFilter(httpServletRequest, httpServletResponse);
        }
    }

    private void validateCode(HttpServletRequest httpServletRequest) throws ValidateCodeException {
        String code = httpServletRequest.getParameter(ParamsConstant.VALIDATE_CODE_CODE);
        String key = httpServletRequest.getParameter(ParamsConstant.VALIDATE_CODE_KEY);
        validateCodeService.check(key, code);
    }

    private String getClientId(String header, HttpServletRequest request) {
        String clientId = "";
        try {
            byte[] base64Token = header.substring(6).getBytes(StandardCharsets.UTF_8);
            byte[] decoded;
            decoded = Base64.getDecoder().decode(base64Token);

            String token = new String(decoded, StandardCharsets.UTF_8);
            int delim = token.indexOf(":");
            if (delim != -1) {
                clientId = new String[]{token.substring(0, delim), token.substring(delim + 1)}[0];
            }
        } catch (Exception ignore) {
        }
        return clientId;
    }
}
