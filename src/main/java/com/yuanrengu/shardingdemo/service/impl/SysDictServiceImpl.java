package com.yuanrengu.shardingdemo.service.impl;

import com.yuanrengu.shardingdemo.mapper.SysDictMapper;
import com.yuanrengu.shardingdemo.model.SysDict;
import com.yuanrengu.shardingdemo.service.SysDictService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class SysDictServiceImpl implements SysDictService {

    @Resource
    private SysDictMapper sysDictMapper;

    @Override
    public SysDict getDictByCode(String dataCode) {
        return sysDictMapper.getDictByCode(dataCode);
    }

    @Override
    public int addDict(SysDict sysDict) {
        return sysDictMapper.addDict(sysDict);
    }
}
