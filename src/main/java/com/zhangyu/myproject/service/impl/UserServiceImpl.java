package com.zhangyu.myproject.service.impl;

import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * @author ZhangYu
 * @date 2021/9/13 19:59
 **/
@Service
public class UserServiceImpl implements UserDetailsService {
    private final PasswordEncoder pe;

    public UserServiceImpl(PasswordEncoder pe) {
        this.pe = pe;
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {

        // 1. 根据username查询数据库(假设数据库查询出来的是:{"admin":"123456"})
        if(!"admin".equals(s)){
            throw new UsernameNotFoundException("用户名或密码错误");
        }

        // 2.根据查询的对象比较密码
        String password = pe.encode("admin");

        // 3.返回用户对象
        return new User("admin", password,
                AuthorityUtils.commaSeparatedStringToAuthorityList("admin,normal"));
    }
}
