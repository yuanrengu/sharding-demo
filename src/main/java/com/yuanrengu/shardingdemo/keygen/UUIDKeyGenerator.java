package com.yuanrengu.shardingdemo.keygen;

import com.yuanrengu.shardingdemo.keygen.algorithm.UUIDAlgorithm;
import org.apache.shardingsphere.spi.keygen.ShardingKeyGenerator;

import java.util.Properties;

/**
 * ShardingSphere内置的主键生成器：UUID、SNOWFLAKE、LEAF
 * 这里只是为了演示如何自定义主键生成器
 */
public class UUIDKeyGenerator implements ShardingKeyGenerator {

    @Override
    public Comparable<?> generateKey() {
        return UUIDAlgorithm.generateKey();
    }

    @Override
    public String getType() {
        return "UUIDGenerator";
    }

    @Override
    public Properties getProperties() {
        return null;
    }

    @Override
    public void setProperties(Properties properties) {

    }
}
