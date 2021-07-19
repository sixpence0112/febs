package com.cxf.febs.common.security.starter.handler;

import com.cxf.febs.common.core.entity.FebsResponse;
import com.cxf.febs.common.core.utils.FebsUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author sixpence
 * @version 1.0 2021/7/19
 */
@Slf4j
public class FebsAuthExceptionEntryPoint implements AuthenticationEntryPoint {
    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response,
                         AuthenticationException authException) throws IOException {
        String requestUri = request.getRequestURI();
        int status = HttpServletResponse.SC_UNAUTHORIZED;
        String message = "访问令牌不合法";
        log.error("客户端访问{}请求失败: {}", requestUri, message, authException);
        FebsUtil.makeJsonResponse(response, status, new FebsResponse().message(message));
    }
}
