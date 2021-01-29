package com.star.springcloud.myhandler;

import com.alibaba.csp.sentinel.slots.block.BlockException;

public class CustomerBlockHandler {

    public static String handleException(BlockException exception){
        return "sorry";
    }
}
