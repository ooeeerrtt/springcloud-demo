package com.star.springcloud.controller;

import com.star.springcloud.server.FeignService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class FeignContrloller {

    @Resource
    private FeignService feignService;  // 获取声明的Feign的server接口

    @GetMapping(value = "/consumer/test")
    public String ConsumerTest(){
        return "consumer";
    }

    // 调用服务端的get请求
    @GetMapping(value = "/consumer/demo/id/{id}")
    public String ConsumerDemo1(@PathVariable("id") Integer id){
        return feignService.demo2(id);
    }

    // 调用服务端的post请求
    @GetMapping(value = "/consumer/demo/name/{name}/sex/{sex}")
    public String ConsumerDemo2(@PathVariable("name") String name,
                                @PathVariable("sex") String sex){
        return feignService.demo3(name, sex);
    }
}
