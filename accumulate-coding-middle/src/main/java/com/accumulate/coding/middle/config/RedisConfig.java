package com.accumulate.coding.middle.config;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.redis.connection.RedisPassword;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.lettuce.LettuceClientConfiguration;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.connection.lettuce.LettucePoolingClientConfiguration;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import java.io.Serializable;
import java.time.Duration;

/**
 * @Author: Huaaaaaa
 * Date:  2020/11/10
 * Todo: Configuration about redis
 * Time 9:54
 */
@Configuration
public class RedisConfig {

    @Value("${spring.redis.database}")
    private int database;

    @Value("${spring.redis.timeout}")
    private int timeout;

    //最大活跃连接数，默认为8
    @Value("${spring.redis.lettuce.pool.max-total}")
    private int poolMaxTotal;

    //最大空闲连接数，默认8
    @Value("${spring.redis.lettuce.pool.max-idle}")
    private int poolMaxIdle;

    //最小空闲连接数，默认0
    @Value("${spring.redis.lettuce.pool.min-idle}")
    private int poolMinIdle;

    //阻塞时最长等待时间，单位毫秒，默认-1，表示没有限制，会一直等下去
    @Value("${spring.redis.lettuce.pool.max-wait}")
    private int poolMaxWait;

    @Value("${spring.redis.host}")
    private String host;

    @Value("${spring.redis.port}")
    private int port;

    @Value("${spring.redis.password}")
    private String password;


    /**
     * redis连接池配置
     *
     * @return
     */
    @Bean("redisPool")
    @Primary
    public GenericObjectPoolConfig redisPool() {
        GenericObjectPoolConfig config = new GenericObjectPoolConfig();
        config.setMaxIdle(poolMaxIdle);
        config.setMinIdle(poolMinIdle);
        config.setMaxTotal(poolMaxTotal);
        config.setMaxWaitMillis(poolMaxWait);
        return config;
    }

    /**
     * redis配置
     *
     * @return
     */
    @Primary
    @Bean(name = "redisStandaloneConfiguration")
    public RedisStandaloneConfiguration redisStandaloneConfiguration() {
        RedisStandaloneConfiguration config = new RedisStandaloneConfiguration();
        config.setHostName(host);
        config.setPassword(RedisPassword.of(password));
        config.setPort(port);
        config.setDatabase(database);
        return config;
    }

    /**
     * redis主从模式配置
     *
     * @return
     */
   /* @Bean("redisSentinelConfiguration")
    public RedisSentinelConfiguration redisSentinelConfiguration() {
        RedisSentinelConfiguration sentinelConfiguration = new RedisSentinelConfiguration();
        String[] sentinels = host.split(",");
        List<RedisNode> list = new ArrayList<>();
        for (String sentinel : sentinels) {
            String[] nodes = sentinel.split(":");
            list.add(new RedisNode(nodes[0], Integer.parseInt(nodes[1])));
        }
        sentinelConfiguration.setSentinels(list);
        sentinelConfiguration.setPassword(password);
        sentinelConfiguration.setDatabase(database);
        return sentinelConfiguration;
    }*/

    /**
     * standAloneLettuceConnectionFactory
     *
     * @param redisStandaloneConfiguration
     * @param redisPool
     * @return
     */
    @Primary
    @Bean(name = "standAloneLettuceConnectionFactory", destroyMethod = "destroy")
    public LettuceConnectionFactory standAloneLettuceConnectionFactory(@Qualifier("redisStandaloneConfiguration") RedisStandaloneConfiguration redisStandaloneConfiguration,
                                                                       GenericObjectPoolConfig redisPool) {
        LettuceClientConfiguration clientConfig =
                LettucePoolingClientConfiguration.builder().commandTimeout(Duration.ofMillis(timeout))
                        .poolConfig(redisPool).build();
        return new LettuceConnectionFactory(redisStandaloneConfiguration, clientConfig);
    }


    /**
     * redisSentinelConfiguration 主从版
     *
     * @param redisSentinelConfiguration
     * @param redisPool
     * @return
     */
   /* @Bean(name = "sentinelLettuceConnectionFactory", destroyMethod = "destroy")
    public LettuceConnectionFactory sentinelLettuceConnectionFactory(@Qualifier("redisSentinelConfiguration") RedisSentinelConfiguration redisSentinelConfiguration,
                                                                     GenericObjectPoolConfig redisPool) {
        LettuceClientConfiguration clientConfig =
                LettucePoolingClientConfiguration.builder().commandTimeout(Duration.ofMillis(timeout))
                        .poolConfig(redisPool).build();
        return new LettuceConnectionFactory(redisSentinelConfiguration, clientConfig);
    }*/


    /**
     * RedisTemplate
     *
     * @return
     */
    @Bean("saleRedisTemplate")
    public RedisTemplate<String, Serializable> saleRedisTemplate(@Qualifier("standAloneLettuceConnectionFactory") LettuceConnectionFactory standAloneLettuceConnectionFactory) {
        RedisTemplate<String, Serializable> template = new RedisTemplate<>();
        template.setConnectionFactory(standAloneLettuceConnectionFactory);
        Jackson2JsonRedisSerializer jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer(Object.class);
        ObjectMapper om = new ObjectMapper();
        om.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
        jackson2JsonRedisSerializer.setObjectMapper(om);
        StringRedisSerializer stringRedisSerializer = new StringRedisSerializer();
        // key采用String的序列化方式
        template.setKeySerializer(stringRedisSerializer);
        // hash的key也采用String的序列化方式
        template.setHashKeySerializer(stringRedisSerializer);
        // value序列化方式采用jackson
        template.setValueSerializer(jackson2JsonRedisSerializer);
        // hash的value序列化方式采用jackson
        template.setHashValueSerializer(jackson2JsonRedisSerializer);
        template.afterPropertiesSet();
        return template;
    }


}
