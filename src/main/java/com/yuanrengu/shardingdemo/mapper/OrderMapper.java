package com.yuanrengu.shardingdemo.mapper;


import com.yuanrengu.shardingdemo.model.Order;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface OrderMapper {

    List<Order> getOrderByUserId(Long userId);

    List<Order> getOrderByOrderId(Long orderId);

    List<Order> getOrderByUserIdAndOrderId(@Param("userId") Long userId, @Param("orderId") Long orderId);

    List<Order> getOrderByRemark(String remark);

    int addOrder(Order order);

    int addOrderEncryptor(Order order);

}
