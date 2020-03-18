package com.zhaoshy.guitarhelper;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.zhaoshy.guitarhelper.mapper")
public class GuitarHelperApplication {

    public static void main(String[] args) {
        SpringApplication.run(GuitarHelperApplication.class, args);
    }

}
