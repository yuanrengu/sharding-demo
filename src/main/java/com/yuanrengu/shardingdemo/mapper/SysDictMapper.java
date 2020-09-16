package com.yuanrengu.shardingdemo.mapper;

import com.yuanrengu.shardingdemo.model.SysDict;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SysDictMapper {

    SysDict getDictByCode(String dataCode);

    int addDict(SysDict sysDict);
}
