package com.yuanrengu.shardingdemo.model;

import lombok.Data;

import java.util.Date;


@Data
public class SysDict {

    private Long id;

    private String dataType;

    private String dataCode;

    private String dataValue;

    private Date createTime;
}
