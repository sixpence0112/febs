package com.cxf.febs.server.system;

import com.cxf.febs.common.annotation.EnableFebsAuthExceptionHandler;
import com.cxf.febs.common.annotation.EnableFebsServerProtect;
import com.cxf.febs.common.annotation.FebsCloudApplication;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
@FebsCloudApplication
public class FebsServerSystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(FebsServerSystemApplication.class, args);
    }

}
