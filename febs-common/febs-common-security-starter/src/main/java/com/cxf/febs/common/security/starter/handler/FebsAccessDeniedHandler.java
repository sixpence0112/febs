package com.cxf.febs.common.security.starter.handler;

import com.cxf.febs.common.core.entity.FebsResponse;
import com.cxf.febs.common.core.utils.FebsUtil;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author sixpence
 * @version 1.0 2021/7/19
 */
public class FebsAccessDeniedHandler implements AccessDeniedHandler {
    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException accessDeniedException) throws IOException {
        FebsResponse febsResponse = new FebsResponse();
        FebsUtil.makeJsonResponse(response, HttpServletResponse.SC_FORBIDDEN, febsResponse.message("没有权限访问该资源"));

    }
}
