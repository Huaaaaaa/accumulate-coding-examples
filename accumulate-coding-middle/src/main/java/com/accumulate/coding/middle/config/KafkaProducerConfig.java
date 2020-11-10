package com.accumulate.coding.middle.config;

import com.accumulate.coding.middle.config.values.KafkaProducerConfigValues;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Author: huayingcao2
 * Date:  2020/11/10
 * Todo: Configuration about kafka consumer
 * Time 10:08
 */
@Configuration
public class KafkaProducerConfig {

    @Bean
    @ConfigurationProperties(prefix = "com.accumulate.kafka.config.producer")
    public KafkaProducerConfigValues kafkaProducerConfigValues() {
        return new KafkaProducerConfigValues();
    }
}
