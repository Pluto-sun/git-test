package com.foxconn.springcloud.controller;


import com.foxconn.springcloud.entities.CommonResult;
import com.foxconn.springcloud.entities.Payment;
import com.foxconn.springcloud.service.PaymentFeignServer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class OrderFeignController {
    @Resource
    private PaymentFeignServer paymentFeignServer;
    @GetMapping(value = "/consumer/payment/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id){
        return paymentFeignServer.getPaymentById(id);
    }
    @GetMapping(value = "/consumer/payment/feign/timeout")
    public String paymentFeignTimeout(){
        //openfeign-ribbon,客户端一般默认等待1秒钟
        return paymentFeignServer.paymentFeignTimeout();
    }
}
