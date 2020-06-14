package com.lucius.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lucius.entity.ProductCategory;
import com.lucius.entity.ProductInfo;
import com.lucius.mapper.ProductCategoryMapper;
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
    public ProductInfoMapper mapper;

    @Autowired
    public ProductCategoryMapper categoryMapper;

    //通过类别 商品名查询
    //查询所有商品
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

    @RequestMapping("/getProductListByCheck/{productName}/{categoryType}/{page}/{size}")
    public Page<ProductInfo> getProductListByCheck(
            @PathVariable(value = "productName",required = false)String productName,
            @PathVariable(value = "categoryType",required = false)String categoryType,
            @PathVariable("page")Integer page
            ,@PathVariable("size")Integer size){
        long page1 = (long)page;
        long size1 = (long)size;

//        System.out.println(categoryType);
        QueryWrapper wrapper1 = new QueryWrapper();
        wrapper1.eq("category_Name",categoryType);
        List<ProductCategory> categories=categoryMapper.selectList(wrapper1);
//        System.out.println("打印查询结果");
        System.out.println(categories.get(0));
        ProductCategory category = categories.get(0);
        Page<ProductInfo> page2 = new Page<ProductInfo>(page1,size1);
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.like("product_Name",productName);
//        System.out.println(category.getCategoryType());
        wrapper.eq("category_type",category.getCategoryType());
//        System.out.println("开始查询");
        Page<ProductInfo> list = mapper.selectPage(page2,wrapper);
//        System.out.println(list.);
        return list;
    }



}
