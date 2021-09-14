package com.zhangyu.myproject.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @author ZhangYu
 * @date 2021/9/13 19:50
 **/
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        // 授权
        http.authorizeRequests()
                // 放行登录页面
                .antMatchers("/login.html","/error.html").permitAll()
                // 所有请求都必须被认证
                .anyRequest().authenticated();

        // 表单登录
        http.formLogin()
                // 自定义登录页面
                .loginPage("/login.html")
                // 自定义登录逻辑，看上去就是接受的请求的path，也就是/login的请求会被拦截住然后走UserServiceImpl.java的逻辑
                .loginProcessingUrl("/login")
                // 登录成功的跳转
                .successForwardUrl("/toMain")
                .failureForwardUrl("/toError");



        //关闭csrf防护
        http.csrf().disable();

    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}
