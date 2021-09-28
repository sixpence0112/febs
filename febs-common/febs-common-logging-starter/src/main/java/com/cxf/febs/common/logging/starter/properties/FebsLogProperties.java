package com.cxf.febs.common.logging.starter.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author sixpence
 * @version 1.0 2021/9/27
 */
@ConfigurationProperties(prefix = "febs.log")
public class FebsLogProperties {
    /**
     * 日志上传地址
     */
    private String logstashHost = "127.0.0.1:4560";

    /**
     * 是否开启controller层api调用的日志
     */
    private Boolean enableLogForController = false;

    /**
     * 是否开启ELK日志收集
     */
    private Boolean enableElk = false;

    public String getLogstashHost() {
        return logstashHost;
    }

    public void setLogstashHost(String logstashHost) {
        this.logstashHost = logstashHost;
    }

    public Boolean getEnableLogForController() {
        return enableLogForController;
    }

    public void setEnableLogForController(Boolean enableLogForController) {
        this.enableLogForController = enableLogForController;
    }

    public Boolean getEnableElk() {
        return enableElk;
    }

    public void setEnableElk(Boolean enableElk) {
        this.enableElk = enableElk;
    }
}
