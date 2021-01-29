package com.star.springcloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConfigController {

    @Autowired
    private ConfigurableApplicationContext configurableApplicationContext;

    @Value("${config.info}")
    private String info;  // 获取配置

    @GetMapping(value = "/demo/info")
    public String demo(){
        return info;
    }
}
