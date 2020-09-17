package com.yuanrengu.shardingdemo;

import com.yuanrengu.shardingdemo.model.Order;
import com.yuanrengu.shardingdemo.service.OrderService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.UUID;

@SpringBootTest
class ShardingDemoApplicationTests {

    @Autowired
    OrderService orderService;



    @Test
    void contextLoads() {
    }

    @Test
    public void testInsert() {
        for (int i = 1; i < 10; i++) {
            long orderId = i;
            long userId = i;

            Order order = new Order();
            order.setOrderId(orderId);
            order.setRemark("test");
            order.setUserId(userId);
            orderService.addOrder(order);
        }
    }

    @Test
    public void testGet() {
        Order order = orderService.getOrderByUserId(5L);
        System.out.println("==============");
        System.out.println(order.toString());
        System.out.println("==============");

    }


}
