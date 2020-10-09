package com.cxf.febs.auth;

import com.cxf.febs.common.annotation.EnableFebsAuthExceptionHandler;
import com.cxf.febs.common.annotation.EnableFebsServerProtect;
import com.cxf.febs.common.annotation.FebsCloudApplication;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
@FebsCloudApplication
public class FebsAuthApplication {

    public static void main(String[] args) {
        SpringApplication.run(FebsAuthApplication.class, args);
    }

}
