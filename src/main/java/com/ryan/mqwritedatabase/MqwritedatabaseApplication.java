package com.ryan.mqwritedatabase;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@MapperScan("com.ryan.mqwritedatabase.mapper")
@EnableAsync
@EnableScheduling
public class MqwritedatabaseApplication {

    public static void main(String[] args) {
        SpringApplication.run(MqwritedatabaseApplication.class, args);
    }

}
