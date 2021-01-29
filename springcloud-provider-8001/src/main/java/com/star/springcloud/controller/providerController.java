package com.star.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

@RestController
public class providerController {

    // 获取配置文件中的参数
    @Value("${server.port}")
    private String serverPort;

    // 普通get请求
    @GetMapping(value = "/demo/hello")
    public String demo1() {
        return "hello port:" + serverPort;
    }

    // 带参数的get请求
    @GetMapping(value = "/demo/id/{id}")
    public String demo2(@PathVariable("id") Integer id) {
        return "port : " + serverPort + " input : " + id;
    }

    // post 请求
    @PostMapping(value = "/demo/post")
    public String demo3(@RequestParam("name") String name,
                        @RequestParam("sex") String sex) {
        return "port : " + serverPort + " name: " + name + " sex: " + sex;
    }
}
