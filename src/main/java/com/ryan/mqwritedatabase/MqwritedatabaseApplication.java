package com.ryan.mqwritedatabase;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.ryan.mqwritedatabase.mapper")
public class MqwritedatabaseApplication {

    public static void main(String[] args) {
        SpringApplication.run(MqwritedatabaseApplication.class, args);
    }

}
