package com.yuanrengu.shardingdemo.service;


import com.yuanrengu.shardingdemo.model.Order;

public interface OrderService {

    Order getOrderByUserId(Long userId);

    int addOrder(Order order);
}
