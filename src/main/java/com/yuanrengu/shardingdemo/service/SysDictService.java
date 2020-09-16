package com.yuanrengu.shardingdemo.service;


import com.yuanrengu.shardingdemo.model.SysDict;

public interface SysDictService {

    SysDict getDictByCode(String dataCode);

    int addDict(SysDict sysDict);
}
