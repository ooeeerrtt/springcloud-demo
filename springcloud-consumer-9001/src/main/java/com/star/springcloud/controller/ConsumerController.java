package com.star.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;

@RestController
public class ConsumerController {

    @Resource  // 自动获取IOC容器内的 RestTemplate （在配置类中注入）
    private RestTemplate restTemplate;

    //service-url:
    //  nacos-user-service: http://nacos-payment-provider
    //  服务调用通过 注册中心 找到 http://nacos-payment-provider 对应的服务端
    @Value("${service-url.nacos-user-service}")  // 获取配置文件的参数
    private String serverURL;

    @GetMapping(value = "/consumer/test")
    public String ConsumerTest(){
        return "consumer";
    }

    // 调用服务端的get请求
    @GetMapping(value = "/consumer/demo/id/{id}")
    public String ConsumerDemo1(@PathVariable("id") Integer id){
        return restTemplate.getForObject(serverURL + "/demo/id/"+id, String.class);
    }

    // 调用服务端的post请求
    @GetMapping(value = "/consumer/demo/name/{name}/sex/{sex}")
    public String ConsumerDemo2(@PathVariable("name") String name,
                                @PathVariable("sex") String sex){
        MultiValueMap<String,String> param = new LinkedMultiValueMap<String,String>();
        param.add("name", name);
        param.add("sex", sex);

        return restTemplate.postForObject(serverURL + "/demo/post",param,String.class);
    }

}
