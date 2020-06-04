package com.lucius.controller;

import com.lucius.mapper.ProductCategoryMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author : gaolu email-->g956509785@163.com
 * @Date :  2020-06-04
 **/
@SpringBootTest
class ProductCategoryControllerTest {

    @Autowired
    private ProductCategoryMapper mapper;

    @Test
    public void getProCateList(){
        mapper.selectList(null).forEach(System.out::println);
    }

}
