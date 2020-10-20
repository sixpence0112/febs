package com.cxf.febs.gateway.properties;

import lombok.Data;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;

/**
 * @author sixpence
 * @version 1.0 2020/10/20
 */
@Data
@SpringBootConfiguration
@PropertySource(value = {"classpath:febs-gateway.properties"})
@ConfigurationProperties(prefix = "febs.gateway")
public class FebsGatewayProperties {
    /**
     * 禁止外部访问的 URI，多个值的话以逗号分隔
     */
    private String forbidRequestUri;
}
