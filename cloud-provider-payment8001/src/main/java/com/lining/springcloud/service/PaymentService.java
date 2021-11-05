package com.lining.springcloud.service;

import com.lining.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Param;

/**
 * @author lining
 */
public interface PaymentService {
    /**
     * 增
     *
     * @param payment
     * @return
     */
    int create(Payment payment);

    /**
     * 查
     *
     * @param id
     * @return
     */
    Payment getPaymentById(@Param("id") Long id);
}
