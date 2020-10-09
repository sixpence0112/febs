package com.cxf.febs.common.exception;

/**
 * 权限自定义异常
 * @author sixpence
 * @version 1.0 2020/9/18
 */
public class FebsAuthException extends Exception {

    private static final long serialVersionUID = 4736992625288762743L;

    public FebsAuthException(String message) {
        super(message);
    }
}
