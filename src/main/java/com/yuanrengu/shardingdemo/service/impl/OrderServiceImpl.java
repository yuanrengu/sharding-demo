package com.yuanrengu.shardingdemo.service.impl;

import com.yuanrengu.shardingdemo.mapper.OrderMapper;
import com.yuanrengu.shardingdemo.model.Order;
import com.yuanrengu.shardingdemo.service.OrderService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class OrderServiceImpl implements OrderService {

    @Resource
    private OrderMapper orderMapper;



    @Override
    public Order getOrderByUserId(Long userId) {
        return orderMapper.getOrderByUserId(userId);
    }

    @Override
    public int addOrder(Order order) {
        return orderMapper.addOrder(order);
    }
}
