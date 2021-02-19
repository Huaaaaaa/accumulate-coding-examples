package com.accumulate.coding.middle.config.values;

import lombok.Data;

/**
 * @Author: Huaaaaaa
 * Date:  2020/11/10
 * Todo: values of kafka producer configuration
 * Time 10:15
 */

@Data
public class KafkaProducerConfigValues {

    /**
     * KafkaProducerConfig.TOPIC
     */
    private String topic;

    /**
     * KafkaProducerConfig.BOOTSTRAP_SERVERS_CONFIG
     * kafka服务器
     */
    private String bootStrapServers;

    /**
     * KafkaProducerConfig.ACKS_CONFIG
     * ack级别：
     */
    private String acks = "1";

    /**
     * KafkaProducerConfig.RETRY_BACKOFF_MS_CONFIG
     * 重试次数：
     */
    private int retries = 3;

    /**
     * KafkaProducerConfig.COMPRESSION_TYPE_CONFIG
     * 压缩方式：
     */
    private String compressionType = "none";
    /**
     * KafkaProducerConfig.BATCH_SIZE_CONFIG
     * 批量处理的大小：
     */
    private int batchSize = 16384;
    /**
     * KafkaProducerConfig.BUFFER_MEMORY_CONFIG
     * 缓存大小：
     */
    private long bufferMemory = 8 * 1024 * 1024L;

    /**
     * KafkaProducerConfig.LINGER_MS_CONFIG
     */
    private long lingerMs = 1000L;

    /**
     * KafkaProducerConfig.LINGER_MS_CONFIG
     * 连接超时时间（单位：毫秒）
     */
    private int requestTimeoutMs = 5000;

}
