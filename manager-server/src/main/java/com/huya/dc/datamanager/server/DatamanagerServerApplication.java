package com.huya.dc.datamanager.server;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "com.huya.dc.datamanager.server.dao")
public class DatamanagerServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(DatamanagerServerApplication.class, args);
    }

}
