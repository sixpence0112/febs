package com.cxf.febs.common.core.exception;

/**
 * 验证码异常类
 *
 * @author sixpence
 * @version 1.0 2020/10/10
 */
public class ValidateCodeException extends Exception {

    private static final long serialVersionUID = 7514854456967620043L;

    public ValidateCodeException(String message) {
        super(message);
    }
}