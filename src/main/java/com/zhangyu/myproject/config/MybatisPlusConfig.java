package com.zhangyu.myproject.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * @Author zhangyu
 * @CreateTime 2021/9/13 10:35
 **/
@Configuration
@MapperScan("com.zhangyu.myproject.mapper")
public class MybatisPlusConfig {
}
