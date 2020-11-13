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
     * 获取订单
     * @param orderId 订单id
     * @return
     */
    List<Order> getOrderByOrderId(Long orderId);

    /**
     * 获取订单
     * @param remark 备注
     * @return
     */
    List<Order> getOrderByRemark(String remark);

    /**
     * 获取订单
     * @param userId 用户id
     * @param orderId 订单id
     * @return
     */
    List<Order> getOrderByUserIdAndOrderId(Long userId, Long orderId);

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

    /**
     * 批量插入
     * @param orders
     */
    void batchInsertOrder(List<Order> orders);
}
