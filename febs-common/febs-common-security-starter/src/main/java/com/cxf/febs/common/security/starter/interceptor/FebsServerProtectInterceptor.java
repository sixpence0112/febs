package com.cxf.febs.common.security.starter.interceptor;

import com.cxf.febs.common.core.entity.FebsResponse;
import com.cxf.febs.common.core.entity.constant.FebsConstant;
import com.cxf.febs.common.core.utils.FebsUtil;
import com.cxf.febs.common.security.starter.properties.FebsCloudSecurityProperties;
import org.apache.commons.lang3.StringUtils;
import org.springframework.util.Base64Utils;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author sixpence
 * @version 1.0 2021/7/19
 */
public class FebsServerProtectInterceptor implements HandlerInterceptor {
    private FebsCloudSecurityProperties properties;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (!properties.getOnlyFetchByGateway()) {
            return true;
        }
        String token = request.getHeader(FebsConstant.GATEWAY_TOKEN_HEADER);
        String gatewayToken = new String(Base64Utils.encode(FebsConstant.GATEWAY_TOKEN_VALUE.getBytes()));
        if (StringUtils.equals(token, gatewayToken)) {
            return true;
        } else {
            FebsResponse febsResponse = new FebsResponse();
            FebsUtil.makeJsonResponse(response, HttpServletResponse.SC_FORBIDDEN, febsResponse.message("请通过网关获取资源"));
            return false;
        }
    }

    public void setProperties(FebsCloudSecurityProperties properties) {
        this.properties = properties;
    }
}
