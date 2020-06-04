package com.lucius.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.lucius.entity.SellerInfo;
import com.lucius.mapper.UserMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserMapper userMapper;

    @RequestMapping("/login")
    public String login(@RequestParam("userName")String userName,
                        @RequestParam("password")String password,
                        HttpSession session){


        QueryWrapper wrapper = new QueryWrapper();
        Map<String ,Object> map = new HashMap<>();
        map.put("userName",userName);
        map.put("password",password);
        wrapper.allEq(map);
//        wrapper.inSql()
        List<SellerInfo> list =  userMapper.selectList(wrapper);
        if(list.size()>0){
            session.setAttribute("user",list.get(0));
            //登录成功
            return "{\"code\":\"200\",\"msg\":\"登录成功\"}";
        }else{
            return "{\"code\":\"500\",'msg':\"登录失败\"}";
        }

    }
}
