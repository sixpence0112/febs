package com.cxf.febs.server.system;

import com.cxf.febs.common.security.starter.annotation.EnableFebsCloudResourceServer;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableAsync
//@EnableHasorWeb
@SpringBootApplication
@EnableFebsCloudResourceServer
@EnableTransactionManagement
@MapperScan("com.cxf.febs.server.system.mapper")
public class FebsServerSystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(FebsServerSystemApplication.class, args);
    }

}
