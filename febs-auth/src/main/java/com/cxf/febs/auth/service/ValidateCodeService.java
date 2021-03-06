package com.cxf.febs.auth.service;

import com.cxf.febs.common.core.exception.ValidateCodeException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author sixpence
 * @version 1.0 2020/12/29
 */
public interface ValidateCodeService {
    /**
     * 生成验证码
     *
     * @param request  HttpServletRequest
     * @param response HttpServletResponse
     */
    void create(HttpServletRequest request, HttpServletResponse response) throws IOException, ValidateCodeException;

    /**
     * 校验验证码
     *
     * @param key   前端上送 key
     * @param value 前端上送待校验值
     */
    void check(String key, String value) throws ValidateCodeException;
}
