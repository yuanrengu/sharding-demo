package com.yuanrengu.shardingdemo.mapper;


import com.yuanrengu.shardingdemo.model.Order;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface OrderMapper {

    Order getOrderByUserId(Long userId);

    int addOrder(Order order);

}
