package com.lining.springcloud.controller;

import com.lining.springcloud.entities.CommonResult;
import com.lining.springcloud.entities.Payment;
import com.lining.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author lining
 */
@RestController
@Slf4j
@RequestMapping("payment")
public class PaymentController {
    @Resource
    private PaymentService paymentService;

    @PostMapping("create")
    public CommonResult create(@RequestBody Payment payment) {
        int result = paymentService.create(payment);
        log.info("----插入结果：" + result);
        return result > 0 ? new CommonResult(200, "插入数据库成功", result) : new CommonResult(444, "插入数据失败", null);
    }

    @GetMapping("/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id) {
        Payment payment = paymentService.getPaymentById(id);
        return payment == null ? new CommonResult(444, "查询失败", null) : new CommonResult(200, "查询成功", payment);
    }
}
