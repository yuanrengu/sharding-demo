package com.yuanrengu.shardingdemo.service;


import com.yuanrengu.shardingdemo.model.Order;

import java.util.List;

public interface OrderService {

    List<Order> getOrderByUserId(Long userId);

    int addOrder(Order order);
}
