package com.yuanrengu.shardingdemo.keygen.algorithm;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 基于时间戳生成19位的数字
 * @author ：andy
 * @date ：Created in 2020/10/8
 */
public class SidAlgorithm {

    private static long lastTimestamp = -1L;
    private static int sequence = 0;
    private static final long MAX_SEQUENCE = 100;
    private static final SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmssSSS");

    /**
     * 19 bits number with timestamp (2020100816292475100)
     *
     * @return 19 bits number with timestamp
     */
    public static synchronized long nextSid() {
        long now = timeGen();
        if (now == lastTimestamp) {
            if (sequence++ > MAX_SEQUENCE) {
                now = tilNextMillis(lastTimestamp);
                sequence = 0;
            }
        } else {
            sequence = 0;
        }
        lastTimestamp = now;
        //
        return 100L * Long.parseLong(format.format(new Date(now))) + sequence;
    }

    private static long tilNextMillis(long lastTimestamp) {
        long timestamp = timeGen();
        while (timestamp <= lastTimestamp) {
            timestamp = timeGen();
        }
        return timestamp;
    }

    private static long timeGen() {
        return System.currentTimeMillis();
    }

}
