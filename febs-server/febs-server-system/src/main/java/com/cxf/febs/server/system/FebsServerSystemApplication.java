package com.cxf.febs.server.system;

import com.cxf.febs.common.core.annotation.FebsCloudApplication;
import net.hasor.spring.boot.EnableHasor;
import net.hasor.spring.boot.EnableHasorWeb;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;

@EnableDiscoveryClient
@EnableFeignClients
@EnableHasor
@EnableHasorWeb
@SpringBootApplication
@FebsCloudApplication
@MapperScan("com.cxf.febs.server.system.mapper")
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class FebsServerSystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(FebsServerSystemApplication.class, args);
    }

}
