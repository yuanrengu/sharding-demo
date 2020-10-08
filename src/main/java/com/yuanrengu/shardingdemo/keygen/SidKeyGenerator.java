package com.yuanrengu.shardingdemo.keygen;

import com.yuanrengu.shardingdemo.keygen.algorithm.SidAlgorithm;
import org.apache.shardingsphere.spi.keygen.ShardingKeyGenerator;

import java.util.Properties;

public class SidKeyGenerator implements ShardingKeyGenerator {

    @Override
    public Comparable<?> generateKey() {
        return SidAlgorithm.nextSid();
    }

    @Override
    public String getType() {
        return "SidGenerator";
    }

    @Override
    public Properties getProperties() {
        return null;
    }

    @Override
    public void setProperties(Properties properties) {

    }
}
