package com.zhangyu.myproject.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zhangyu.myproject.domain.User;
import com.zhangyu.myproject.service.UserService;
import com.zhangyu.myproject.mapper.UserMapper;
import org.springframework.stereotype.Service;

/**
 *
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService{

}




