package com.lucius.utils;

import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

/**
 * @author : gaolu email-->g956509785@163.com
 * @Date :  2020-07-29
 **/
@Component
public class ResultFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse rep = (HttpServletResponse) servletResponse;

        //设置允许跨域的配置
        // 这里填写你允许进行跨域的主机ip（正式上线时可以动态配置具体允许的域名和IP）
//        rep.setHeader("Access-Control-Allow-Origin", "*");
//        // 允许的访问方法
//        rep.setHeader("Access-Control-Allow-Methods","POST, GET, PUT, OPTIONS, DELETE, PATCH");
//        // Access-Control-Max-Age 用于 CORS 相关配置的缓存
//        rep.setHeader("Access-Control-Max-Age", "3600");
//        rep.setHeader("Access-Control-Allow-Headers","token,Origin, X-Requested-With, Content-Type, Accept");
//

//        servletResponse.setCharacterEncoding("UTF-8");
//        servletResponse.setContentType("application/json; charset=utf-8");
        String path = req.getRequestURL().toString();
//        System.out.println(path);
        if(path.contains("login")){
            filterChain.doFilter(servletRequest, servletResponse);
        }else {
            String token = req.getHeader("token");//header方式
            System.out.println(token);
            String checkToken = TokenTest.checkToken(token);
            System.out.println("checkToken Result: " + checkToken);
            if (checkToken != "F") {
                filterChain.doFilter(servletRequest, servletResponse);
            } else {

            }
        }
    }

    @Override
    public void destroy() {

    }
}
