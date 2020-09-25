package com.yuanrengu.shardingdemo.service;


import com.yuanrengu.shardingdemo.model.Order;

import java.util.List;

public interface OrderService {

    /**
     * 获取订单
     * @param userId 用户id
     * @return
     */
    List<Order> getOrderByUserId(Long userId);

    /**
     * 新增
     * @param order
     * @return
     */
    int addOrder(Order order);

    /**
     * 新增（配置了数据脱敏）
     * @param order
     * @return
     */
    int addOrderEncryptor(Order order);
}
