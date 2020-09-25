package com.yuanrengu.shardingdemo;

import com.alibaba.fastjson.JSON;
import com.yuanrengu.shardingdemo.model.Order;
import com.yuanrengu.shardingdemo.model.SysDict;
import com.yuanrengu.shardingdemo.service.OrderService;
import com.yuanrengu.shardingdemo.service.SysDictService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.UUID;

@SpringBootTest
class ShardingDemoApplicationTests {

    @Autowired
    OrderService orderService;

    @Autowired
    SysDictService sysDictService;

    @Test
    void contextLoads() {
    }

    @Test
    public void testAdd() {
        for (int i = 1; i < 10; i++) {
            long orderId = i + 1;
            long userId = i;

            Order order = new Order();
            order.setOrderId(orderId);
//            order.setRemark("test");
            order.setUserId(userId);
            orderService.addOrder(order);
        }
    }

    @Test
    public void testaddEncryptor() {
        for (int i = 1; i < 10; i++) {
            long orderId = i + 1;
            long userId = i;

            Order order = new Order();
            order.setOrderId(orderId);
            order.setUserId(userId);
            orderService.addOrderEncryptor(order);
        }
    }

    @Test
    public void testGet() {
        List<Order> orders = orderService.getOrderByUserId(5L);
        System.out.println("==============");
        System.out.println(JSON.toJSONString(orders));
        System.out.println("==============");

    }

    @Test
    public void testAddDict() {
        SysDict sysDict = new SysDict();
        sysDict.setDataCode("andy");
        sysDict.setDataValue("yuanrengu");

        sysDictService.addDict(sysDict);
    }

    @Test
    public void testGetDict() {
        SysDict sysDict = sysDictService.getDictByCode("andy");
        System.out.println("============");
        System.out.println(JSON.toJSONString(sysDict));
        System.out.println("============");
    }


}
