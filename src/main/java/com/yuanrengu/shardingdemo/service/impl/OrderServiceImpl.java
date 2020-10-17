package com.yuanrengu.shardingdemo.service.impl;

import com.yuanrengu.shardingdemo.mapper.OrderMapper;
import com.yuanrengu.shardingdemo.model.Order;
import com.yuanrengu.shardingdemo.service.OrderService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Resource
    private OrderMapper orderMapper;



    @Override
    public List<Order> getOrderByUserId(Long userId) {
        return orderMapper.getOrderByUserId(userId);
    }

    @Override
    public List<Order> getOrderByOrderId(Long orderId) {
        return orderMapper.getOrderByOrderId(orderId);
    }

    @Override
    public List<Order> getOrderByRemark(String remark) {
        return orderMapper.getOrderByRemark(remark);
    }

    @Override
    public List<Order> getOrderByUserIdAndOrderId(Long userId, Long orderId) {
        return orderMapper.getOrderByUserIdAndOrderId(userId, orderId);
    }

    @Override
    public int addOrder(Order order) {
        return orderMapper.addOrder(order);
    }

    @Override
    public int addOrderEncryptor(Order order) {
        return orderMapper.addOrderEncryptor(order);
    }
}
