package com.cxf.febs.auth.controller;

import com.cxf.febs.auth.service.impl.ValidateCodeServiceImpl;
import com.cxf.febs.common.entity.FebsResponse;
import com.cxf.febs.common.exception.FebsAuthException;
import com.cxf.febs.common.exception.ValidateCodeException;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.provider.token.ConsumerTokenServices;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.security.Principal;

/**
 * @author sixpence
 * @version 1.0 2020/9/18
 */
@RestController
public class SecurityController {

    @Autowired
    private ConsumerTokenServices consumerTokenServices;
    @Autowired
    private ValidateCodeServiceImpl validateCodeService;

    @GetMapping("oauth/test")
    public String testAuth() {
        return "oauth";
    }

    @GetMapping("user")
    public Principal currentUser(Principal principal) {
        return principal;
    }

    @DeleteMapping("signout")
    public FebsResponse signout(HttpServletRequest request) throws FebsAuthException {
        String authorization = request.getHeader("Authorization");
        String token = StringUtils.replace(authorization, "bearer ", "");
        FebsResponse febsResponse = new FebsResponse();
        if (!consumerTokenServices.revokeToken(token)) {
            throw new FebsAuthException("退出登录失败");
        }
        return febsResponse.message("退出登录成功");
    }

    @GetMapping("captcha")
    public void captcha(HttpServletRequest request, HttpServletResponse response) throws ValidateCodeException, IOException {
        validateCodeService.create(request, response);
    }
}
