package com.lucius.controller;

import com.lucius.entity.ProductCategory;
import com.lucius.mapper.ProductCategoryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author : gaolu email-->g956509785@163.com
 * @Date :  2020-06-04
 **/
@RestController
@RequestMapping("/proCate")
public class ProductCategoryController {

    @Autowired
    private ProductCategoryMapper mapper;

    //查询所有商品类目
    @RequestMapping("/getProCateList")
    public List<ProductCategory> getProductCategoryList(){

        return mapper.selectList(null);
    }
}
