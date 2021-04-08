package com.cxf.febs.server.system.properties;

import lombok.Data;

/**
 * 个推配置属性
 * @author sixpence
 * @version 1.0 2021/1/22
 */
@Data
public class FebsAppPushProperties {

    /**
     * 应用与SDK通信的标识之一，每个应用都对应一个唯一的AppID
     */
    private String appId;
    /**
     * 预先分配的第三方应用对应的Key，应用与SDK通信的标识之一
     */
    private String appKey;
    /**
     * 服务端API鉴权码，用于验证调用方合法性
     */
    private String masterSecret;
    /**
     * 接口调用地址
     */
    private String domain;

}
