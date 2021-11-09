package com.xwtech;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.xwtech.dao")
public class BootStartApplication {

    public static void main(String[] args) {
        SpringApplication.run(BootStartApplication.class, args);
    }

}
