package com.cxf.febs.common.interceptor;

import com.alibaba.fastjson.JSONObject;
import com.cxf.febs.common.entity.constant.FebsConstant;
import com.cxf.febs.common.entity.FebsResponse;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.MediaType;
import org.springframework.util.Base64Utils;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 校验zuultoken
 * @author sixpence
 * @version 1.0 2020/10/9
 */
public class FebsServerProtectInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //从请求中获取Zuul Token
        String token = request.getHeader(FebsConstant.GATEWAY_TOKEN_HEADER);
        String zuulToken = new String(Base64Utils.encode(FebsConstant.GATEWAY_TOKEN_VALUE.getBytes()));
        //校验Zuul Token的正确性
        if (StringUtils.equals(token, zuulToken)) {
            return true;
        } else {
            FebsResponse febsResponse = new FebsResponse();
            response.setContentType(MediaType.APPLICATION_JSON_VALUE);
            response.setStatus(HttpServletResponse.SC_FORBIDDEN);
            response.getWriter().write(JSONObject.toJSONString(febsResponse.message("请通过网关获取资源")));
            return false;
        }
    }
}
