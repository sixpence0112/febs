package com.cxf.febs.auth;

import com.cxf.febs.common.core.annotation.EnableFebsLettuceRedis;
import com.cxf.febs.common.security.starter.annotation.EnableFebsCloudResourceServer;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableFebsLettuceRedis
@EnableFebsCloudResourceServer
@MapperScan("com.cxf.febs.auth.mapper")
public class FebsAuthApplication {

    public static void main(String[] args) {
        SpringApplication.run(FebsAuthApplication.class, args);
    }

}
