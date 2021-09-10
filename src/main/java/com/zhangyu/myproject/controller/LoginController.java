package com.zhangyu.myproject.controller;

import org.springframework.web.bind.annotation.*;

/**
 * @Author zhangyu
 * @CreateTime 2021/9/10 15:07
 **/

@RestController("/test")
public class LoginController {

    @PostMapping("/login")
    public String login(@RequestParam String username, @RequestParam String password){


        return "ok";
    }

}
