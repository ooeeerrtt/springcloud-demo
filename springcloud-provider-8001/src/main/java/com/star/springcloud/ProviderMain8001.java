package com.star.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication  // 启动类的数据
@EnableDiscoveryClient  // 声明此注解可以让注册中心发现，扫描该服务
public class ProviderMain8001 {
    public static void main(String[] args) {
        SpringApplication.run(ProviderMain8001.class, args);
    }
}
