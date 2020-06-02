package com.lucius.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.util.Date;

/**
 * @author : gaolu email-->g956509785@163.com
 * @Date :  2020-05-28
 **/
@Data
public class ProductInfo {

    @TableId
    private String productId;
    private String productName;
    private Integer productPrice;
    private Integer productStock;
    private String productDescription;
    private String productIcon;
    private String productStatus;
    private Integer categoryType;
    private Date createTime;
    private Date updateTime;

}
