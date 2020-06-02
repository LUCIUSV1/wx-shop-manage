package com.lucius;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.lucius.mapper")
public class WxShopManageApplication {

    public static void main(String[] args) {
        SpringApplication.run(WxShopManageApplication.class, args);
    }

}
