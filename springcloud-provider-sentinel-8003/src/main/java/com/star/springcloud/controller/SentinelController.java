package com.star.springcloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.star.springcloud.myhandler.CustomerBlockHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SentinelController {

    @GetMapping(value = "/test")
    public String test(){
        return "----------test----------";
    }

    @GetMapping(value = "/testerror")
    public String testError(){
        int a = 10/0;
        return "----------test----------";
    }

    @GetMapping(value = "/testa")
    @SentinelResource(value = "test1" ,blockHandler = "deal_testHotKey")
    public String testA(){
        return "----------testA----------";
    }

    @GetMapping(value = "/testb")
    @SentinelResource(value = "test1" ,blockHandler = "deal_testHotKey")
    public String testB(){
        return "----------testB----------";
    }

    @GetMapping(value = "/testc")
    @SentinelResource(value = "test2" ,blockHandlerClass = CustomerBlockHandler.class,blockHandler = "handleException")
    public String testC(){
        return "----------testc----------";
    }

    @GetMapping(value = "/testd")
    @SentinelResource(value = "test2" ,blockHandlerClass = CustomerBlockHandler.class,blockHandler = "handleException")
    public String testD(){
        return "----------testd----------";
    }

    //兜底方法
    public String deal_testHotKey (BlockException exception){
        return "------deal_testHotKey,o(╥﹏╥)o";
    }


}
