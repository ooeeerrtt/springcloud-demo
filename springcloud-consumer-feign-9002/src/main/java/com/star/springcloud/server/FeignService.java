package com.star.springcloud.server;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Component
@FeignClient(value = "nacos-payment-provider")  // 注册中心要调用的服务端的应用名
public interface FeignService {
    /*
        此接口的所有与服务端的方法一致，但是不需要实现
     */
    // 普通get请求
    @GetMapping(value = "/demo/hello")
    public String demo1();

    // 带参数的get请求
    @GetMapping(value = "/demo/id/{id}")
    public String demo2(@PathVariable("id") Integer id);

    // post 请求
    @PostMapping(value = "/demo/post")
    public String demo3(@RequestParam("name") String name, @RequestParam("sex") String sex);
}
