package com.cxf.febs.sever.generator;

import com.cxf.febs.common.security.starter.annotation.EnableFebsCloudResourceServer;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableFebsCloudResourceServer
@MapperScan("com.cxf.febs.sever.generator.mapper")
public class FebsSeverGeneratorApplication {

    public static void main(String[] args) {
        SpringApplication.run(FebsSeverGeneratorApplication.class, args);
    }

}
