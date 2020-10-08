package com.yuanrengu.shardingdemo.keygen.algorithm;

import java.util.UUID;

/**
 * UUID生成算法
 * @author ：andy
 * @date ：Created in 2020/10/8
 */
public class UUIDAlgorithm {

    public static synchronized String generateKey() {
        return UUID.randomUUID().toString().replaceAll("-", "");
    }

}
