package com.cxf.febs.server.system.properties;

import lombok.Data;

/**
 * @author sixpence
 * @version 1.0 2020/10/15
 */
@Data
public class FebsSwaggerProperties{

    private String basePackage;
    private String title;
    private String description;
    private String version;
    private String author;
    private String url;
    private String email;
    private String license;
    private String licenseUrl;
    private String grantUrl;
    private String name;
    private String scope;

}
