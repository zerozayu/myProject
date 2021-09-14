package com.zhangyu.myproject.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author zhangyu
 * @CreateTime 2021/9/10 15:07
 **/

@RestController
public class LoginController {

    @PostMapping("/toMain")
    public ModelAndView toMain(){
        // 重定向
        return new ModelAndView("redirect:main.html");
        // return "redirect:/main";
    }

    @PostMapping("/toError")
    public ModelAndView toError(){
        // 重定向
        return new ModelAndView("redirect:error.html");
    }

}
