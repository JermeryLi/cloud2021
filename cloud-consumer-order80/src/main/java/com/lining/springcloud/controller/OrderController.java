package com.lining.springcloud.controller;

import com.lining.springcloud.entities.CommonResult;
import com.lining.springcloud.entities.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.ArrayList;

/**
 * @author lining
 */
@RestController
@Slf4j
@RequestMapping("/consumer/payment/")
public class OrderController {
    private static final String PAYMENT_URL = "http://localhost:8001";

    private static final String PAYMENT_REQUEST_URL = "/payment/create";

    private static final String PAYMENT_REQUEST_GET_URL = "/payment/get/";
    @Resource
    private RestTemplate restTemplate;

    @PostMapping("create")
    public CommonResult create(@RequestBody Payment payment) {
        System.out.println();
        return restTemplate.postForObject(PAYMENT_URL + PAYMENT_REQUEST_URL, payment, CommonResult.class);
    }

    @GetMapping("get/{id}")
    public CommonResult getPayment(@PathVariable("id") Long id) {
        return restTemplate.getForObject(PAYMENT_URL + PAYMENT_REQUEST_GET_URL + id, CommonResult.class);
    }

}
