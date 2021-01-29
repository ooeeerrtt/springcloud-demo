package com.star.springcloud.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SentinelController {
    @GetMapping(value = "/testc")
    public String testA(){
        return "----------testC----------";
    }

    @GetMapping(value = "/testd")
    public String testB(){
        return "----------testD----------";
    }
}
