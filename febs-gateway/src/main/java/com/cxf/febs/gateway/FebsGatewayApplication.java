package com.cxf.febs.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

/**
 * @author sixpence
 * @version 1.0 2020/10/29
 */
@SpringBootApplication
public class FebsGatewayApplication {
    public static void main(String[] args) {
        new SpringApplicationBuilder(FebsGatewayApplication.class)
                .web(WebApplicationType.REACTIVE)
                .run(args);
    }
}
