package com.foxconn.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.Map;

//@ResponseBody
//@Controller
@RestController
public class HelloController {
    @RequestMapping("/hello")
    public String hello(){
        return "hello world ";
    }

    @RequestMapping("/success")
    public String success(Map<String,Object> map){
        map.put("hello","你好");
        map.put("user", Arrays.asList("zahngsan","lisi"));
        return "success";
    }
}
