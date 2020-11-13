package com.yuanrengu.shardingdemo;

import com.alibaba.fastjson.JSON;
import com.yuanrengu.shardingdemo.model.Order;
import com.yuanrengu.shardingdemo.model.SysDict;
import com.yuanrengu.shardingdemo.service.OrderService;
import com.yuanrengu.shardingdemo.service.SysDictService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
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
            long orderId = i;
            long userId = i;

            Order order = new Order();
            order.setOrderId(orderId);
//            order.setRemark("test");
            order.setUserId(userId);
            orderService.addOrder(order);
        }
    }



    @Test
    public void testBatchAdd() {
        // 批量插入测试
        List<Order> orderList = new ArrayList<>();
        for (int i = 1; i < 10; i++) {
            long orderId = i;
            long userId = i;

            Order order = new Order();
            order.setOrderId(orderId);
            order.setUserId(userId);
            orderList.add(order);
        }

        orderService.batchInsertOrder(orderList);
    }

    @Test
    public void testaddEncryptor() {
        for (int i = 20; i < 30; i++) {
            long orderId = i + 1;
            long userId = i;

            Order order = new Order();
            order.setOrderId(orderId);
            order.setUserId(userId);
            orderService.addOrderEncryptor(order);
        }
    }

    @Test
    public void testGetOrderByUserId() {
        List<Order> orders = orderService.getOrderByUserId(5L);
        System.out.println("==============");
        System.out.println(JSON.toJSONString(orders));
        System.out.println("==============");
    }


    @Test
    public void testGetOrder() {
        // 演示不同查询字段（分表字段、分库字段、非分库分表字段）会请求多少条语句
//        List<Order> orders1 = orderService.getOrderByOrderId(5L);
//        System.out.println("==============");
//        System.out.println(JSON.toJSONString(orders1));
//        System.out.println("==============");
//
//        List<Order> orders2 = orderService.getOrderByUserId(5L);
//        System.out.println("==============");
//        System.out.println(JSON.toJSONString(orders2));
//        System.out.println("==============");

//        List<Order> orders3 = orderService.getOrderByRemark("555");
//        System.out.println("==============");
//        System.out.println(JSON.toJSONString(orders3));
//        System.out.println("==============");

        List<Order> orders4 = orderService.getOrderByUserIdAndOrderId(5L, 5L);
        System.out.println("==============");
        System.out.println(JSON.toJSONString(orders4));
        System.out.println("==============");

    }

    @Test
    public void testAddDict() {
        SysDict sysDict = new SysDict();
        sysDict.setDataCode("QDAMA");
        sysDict.setDataValue("全球卖菜");

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
