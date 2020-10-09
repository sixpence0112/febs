package com.cxf.febs.auth.properties;

import lombok.Data;

/**
 * @author sixpence
 * @version 1.0 2020/9/21
 */
@Data
public class FebsClientsProperties {
    private String client;
    private String secret;
    private String grantType = "password,authorization_code,refresh_token";
    private String scope = "all";
}
