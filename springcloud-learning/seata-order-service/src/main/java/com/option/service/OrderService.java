package com.option.service;

import com.option.domain.Order;

public interface OrderService {

    /**
     * 创建订单
     */
    void create(Order order);
}
