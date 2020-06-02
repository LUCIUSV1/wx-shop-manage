package com.lucius;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lucius.entity.ProductInfo;
import com.lucius.mapper.ProductInfoMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class WxShopManageApplicationTests {

    @Autowired
    private ProductInfoMapper mapper;
    @Test
    void contextLoads() {

        Page<ProductInfo> page = new Page<ProductInfo>(1,5);
        QueryWrapper wrapper = new QueryWrapper();
        System.out.println( mapper.selectPage(page,wrapper));

    }

}
