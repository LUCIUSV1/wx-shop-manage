package com.lucius.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Data
public class SellerInfo {
    @TableId(value = "id")
    private Integer userId;
    @TableField(value = "username")
    private String userName;
    private String password;
    @TableField(value = "openId")
    private String openId;
    @TableField(value = "create_Time")
    private Date createTime;
    @TableField(value = "update_Time")
    private Date updateTime;
}
