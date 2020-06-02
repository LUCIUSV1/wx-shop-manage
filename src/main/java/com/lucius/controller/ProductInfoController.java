package com.lucius.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lucius.entity.ProductInfo;
import com.lucius.mapper.ProductInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author : gaolu email-->g956509785@163.com
 * @Date :  2020-05-28
 **/
@RestController
@RequestMapping("/pro")
public class ProductInfoController {

    @Autowired
    private ProductInfoMapper mapper;

    @RequestMapping("/getProductList/{page}/{size}")
    public Page<ProductInfo> getProductList(@PathVariable("page")Integer page
            ,@PathVariable("size")Integer size){
        long page1 = (long)page;
        long size1 = (long)size;

        Page<ProductInfo> page2 = new Page<ProductInfo>(page1,size1);
        QueryWrapper wrapper = new QueryWrapper();
        Page<ProductInfo> list = mapper.selectPage(page2,wrapper);
//        System.out.println(list.);
        return list;
    }
}
