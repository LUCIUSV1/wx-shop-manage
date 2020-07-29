//package com.lucius.config;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.builders.WebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.crypto.password.NoOpPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//
///**
// * @author : gaolu email-->g956509785@163.com
// * @Date :  2020-07-08
// **/
//@Configuration
//public class SecurityConfig extends WebSecurityConfigurerAdapter {
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.inMemoryAuthentication().withUser("lucius").password("1234")
//                .roles("admin");
//    }
//
//
//    //放行静态资源
//    @Override
//    public void configure(WebSecurity web) throws Exception {
//       web.ignoring().antMatchers("/*/**","/css/**","/images/**");
//    }
//    //.permitAll()
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http.authorizeRequests().anyRequest().authenticated()
//                .and().formLogin()
//                .loginPage("http://192.168.1.155:8080/login")
////                .loginProcessingUrl("http://192.168.1.155:8080/login")
//        .and().csrf().disable().sessionManagement().maximumSessions(1)
//        .maxSessionsPreventsLogin(true)
//        ;
//    }
//
//    @Bean
//    PasswordEncoder passwordEncoder(){
//        return NoOpPasswordEncoder.getInstance();
//    }
//
//
//
//
//}
