package com.zhangyu.myproject;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.zhangyu.myproject.domain.Role;
import com.zhangyu.myproject.mapper.RoleMapper;
import com.zhangyu.myproject.service.RoleService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.*;

@SpringBootTest
class MyProjectApplicationTests {
    @Autowired
    RoleMapper roleMapper;

    @Autowired
    RoleService roleService;


    @Test
    void tset5(){
        Role role = new Role();
        role.setName("admin");
        role.setCode("a_001");
        boolean save = roleService.save(role);
        System.out.println(role);
    }
    @Test
    void tset6(){
        Role role = new Role();
        role.setName("admin");
        role.setCode("a_002");

        Wrapper<Role> wrapper = new UpdateWrapper<Role>().eq("name", "admin");

        roleMapper.update(role, wrapper);

        Role one = roleService.query()
                .eq("name", "admin")
                .one();
        System.out.println(one);
    }


}
