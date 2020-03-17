package com.zhaoshy.shoppinghelper;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.zhaoshy.shoppinghelper.mapper")
public class ShoppinghelperApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShoppinghelperApplication.class, args);
    }

}
