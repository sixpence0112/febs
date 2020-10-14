package com.cxf.febs.server.system;

import com.cxf.febs.common.annotation.EnableFebsAuthExceptionHandler;
import com.cxf.febs.common.annotation.EnableFebsServerProtect;
import com.cxf.febs.common.annotation.FebsCloudApplication;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;

@EnableDiscoveryClient
@EnableFeignClients
@SpringBootApplication
@FebsCloudApplication
@MapperScan("com.cxf.febs.server.system.mapper")
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class FebsServerSystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(FebsServerSystemApplication.class, args);
    }

}
