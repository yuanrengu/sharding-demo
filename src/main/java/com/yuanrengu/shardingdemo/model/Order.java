package com.yuanrengu.shardingdemo.model;

import lombok.Data;

import java.util.Date;

@Data
public class Order {

    private Long id;

    private Long userId;

    private Long orderId;

    private String remark;

    private Date createTime;

}
