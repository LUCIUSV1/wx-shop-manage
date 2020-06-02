package com.lucius.config;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author : gaolu email-->g956509785@163.com
 * @Date :  2020-06-01
 **/

@Configuration
public class MyBatisPlusConfig {
    @Bean
    public PaginationInterceptor paginationInterceptor() {
        return new PaginationInterceptor();

    }
}
