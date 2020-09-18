package com.yuanrengu.shardingdemo.sharding.standard;

import com.alibaba.fastjson.JSON;
import org.apache.shardingsphere.api.sharding.standard.PreciseShardingAlgorithm;
import org.apache.shardingsphere.api.sharding.standard.PreciseShardingValue;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Collection;

/**
 * 精确分片（分库）
 * @author ：yuanrengu
 * @date ：Created in 2020/9/18
 */
public class PreciseShardingDatebase implements PreciseShardingAlgorithm<Long> {

    private static final Logger logger = LoggerFactory.getLogger(PreciseShardingDatebase.class);

    @Override
    public String doSharding(Collection<String> collection, PreciseShardingValue<Long> preciseShardingValue) {
        logger.info("PreciseShardingDatebase,collection:{},preciseShardingValue:{}", JSON.toJSONString(collection), JSON.toJSONString(preciseShardingValue));

        Long userId = preciseShardingValue.getValue();
        for (String database : collection) {
            if (database.endsWith(String.valueOf(userId % 4))) {
                return database;
            }
        }

        return null;
    }

}
