package com.cxf.febs.common.core.exception;

/**
 * 文件下载异常
 *
 * @author sixpence
 * @version 1.0 2020/12/31
 */
public class FileDownloadException extends Exception {

    private static final long serialVersionUID = 5015255191021027972L;

    public FileDownloadException(String message) {
        super(message);
    }
}
