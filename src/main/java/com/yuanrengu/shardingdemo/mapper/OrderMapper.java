package com.yuanrengu.shardingdemo.mapper;


import com.yuanrengu.shardingdemo.model.Order;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface OrderMapper {

    List<Order> getOrderByUserId(Long userId);

    int addOrder(Order order);

    int addOrderEncryptor(Order order);

}
