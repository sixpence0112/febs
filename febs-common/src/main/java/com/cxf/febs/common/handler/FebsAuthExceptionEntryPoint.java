package com.cxf.febs.common.handler;

import com.cxf.febs.common.entity.FebsResponse;
import com.cxf.febs.common.utils.FebsUtil;
import org.springframework.http.MediaType;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author sixpence
 * @version 1.0 2020/9/27
 */
public class FebsAuthExceptionEntryPoint implements AuthenticationEntryPoint {
    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response,
                         AuthenticationException e) throws IOException {

        FebsResponse febsResponse = new FebsResponse();
        FebsUtil.makeResponse(response, MediaType.APPLICATION_JSON_VALUE,
                HttpServletResponse.SC_UNAUTHORIZED, febsResponse.message("token无效"));

    }
}
