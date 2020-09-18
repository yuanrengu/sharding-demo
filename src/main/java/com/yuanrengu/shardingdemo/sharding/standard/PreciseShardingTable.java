package com.yuanrengu.shardingdemo.sharding.standard;

import com.alibaba.fastjson.JSON;
import org.apache.shardingsphere.api.sharding.standard.PreciseShardingAlgorithm;
import org.apache.shardingsphere.api.sharding.standard.PreciseShardingValue;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Collection;

/**
 * 精确分片（分表）
 * @author ：yuanrengu
 * @date ：Created in 2020/9/18
 */
public class PreciseShardingTable implements PreciseShardingAlgorithm<Long>  {

    private static final Logger logger = LoggerFactory.getLogger(PreciseShardingTable.class);

    @Override
    public String doSharding(Collection<String> collection, PreciseShardingValue<Long> preciseShardingValue) {
        logger.info("PreciseShardingTable,collection:{},preciseShardingValue:{}", JSON.toJSONString(collection), JSON.toJSONString(preciseShardingValue));

        Long orderId = preciseShardingValue.getValue();
        for (String table : collection) {
            if (table.endsWith(String.valueOf(orderId % 2))) {
                return table;
            }
        }
        return null;
    }
}
