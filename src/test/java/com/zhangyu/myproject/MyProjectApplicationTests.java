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
    UserMapper userMapper;

    @Autowired
    RoleMapper roleMapper;

    @Autowired
    RoleService roleService;

    @Test
    void contextLoads() {
        User user = userMapper.selectById(1);
        System.out.println(user);
    }

    @Test
    void test1() {
        Map<String, Object> map = new HashMap<>();
        // map.put("tablename", "tbl_user");
        map.put("id", 4);
        Map<String, Object> map1 = userMapper.selectById1("tbl_user", map);
        System.out.println(map1);
    }

    @Test
    void test2(){
        User user = new User(4,"liulei",13,new Date(),"qqq");
        int i = userMapper.updateById(user);
        System.out.println(i);
        System.out.println(userMapper.selectById(1));

    }

    @Test
    void tset3(){
        User user = new User("zhangyu",14,new Date(),"qqq");
        System.out.println(userMapper.insert(user));
        System.out.println(user);
    }

    @Test
    void tset4(){

        List<Integer> list = Arrays.asList(1,2,3);
        System.out.println(userMapper.deleteByIds(list));
    }


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
