package com.lucius.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.lucius.entity.SellerInfo;
import com.lucius.mapper.UserMapper;

import com.lucius.result.LoginResult;
import com.lucius.utils.TokenTest;
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

    @RequestMapping("/login/{userName}/{password}")
    public LoginResult login(@PathVariable("userName")String userName,
                        @PathVariable("password")String password,
                        HttpSession session){
        QueryWrapper wrapper = new QueryWrapper();
        QueryWrapper wrapper1 = new QueryWrapper();
        Map<String ,Object> map2 = new HashMap<>();
        map2.put("userName",userName);
        wrapper1.allEq(map2);
        Map<String ,Object> map = new HashMap<>();
        map.put("userName",userName);
        map.put("password",password);
        wrapper.allEq(map);
//        wrapper.inSql()
        List<SellerInfo> list =  userMapper.selectList(wrapper);
        List<SellerInfo> list1 =  userMapper.selectList(wrapper1);
        if(list.size()>0){
//            session.setAttribute("user",list.get(0));
            //获取token
            String str = userName+"_and_"+password;
            String token = TokenTest.getToken(str);
            Map<String,Object> map1 = new HashMap<String,Object>();
//            map1.put("userName",userName);
            map1.put("token",token);

            //登录成功
            return new LoginResult(200,"登录成功",map1);
        }else if(list1.size()<=0){
            return new LoginResult(401,"用户名不存在",null);
        }
        else{
            return new LoginResult(500,"登录失败，密码错误",null);
        }

    }
}
