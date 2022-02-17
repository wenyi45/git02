package com.xu;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

/**
 * 配置类
 */
@SpringBootApplication
@MapperScan("com.xu.dao")
@EnableCaching
public class Starter {
    public static void main(String[] args) {
        SpringApplication.run(Starter.class);

    }
}
