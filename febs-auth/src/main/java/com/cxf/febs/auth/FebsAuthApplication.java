package com.cxf.febs.auth;

import com.cxf.febs.common.annotation.EnableFebsAuthExceptionHandler;
import com.cxf.febs.common.annotation.EnableFebsServerProtect;
import com.cxf.febs.common.annotation.FebsCloudApplication;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableDiscoveryClient
@SpringBootApplication
@FebsCloudApplication
@EnableFebsAuthExceptionHandler
@MapperScan("com.cxf.febs.auth.mapper")
public class FebsAuthApplication {

    public static void main(String[] args) {
        SpringApplication.run(FebsAuthApplication.class, args);
    }

}
