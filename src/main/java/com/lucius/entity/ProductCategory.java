package com.lucius.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.util.Date;

/**
 * @author : gaolu email-->g956509785@163.com
 * @Date :  2020-06-04
 **/
@Data
public class ProductCategory {
    @TableId
    private Integer categoryId;
    private String categoryName;
    private Integer categoryType;
    private Date createTime;
    private Date updateTime;

}
