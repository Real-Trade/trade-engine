package com.realtrade.tradeengine.config;
import org.springframework.context.annotation.Configuration;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.time.Duration;

@Configuration
public class RedisPoolConfig {
    private static JedisPool pool;

    private static void initPool() {
        final JedisPoolConfig poolConfig = new JedisPoolConfig();
        poolConfig.setMaxTotal(128);
        poolConfig.setMaxIdle(128);
        poolConfig.setMinIdle(16);
        poolConfig.setTestOnBorrow(true);
        poolConfig.setTestOnReturn(true);
        poolConfig.setTestWhileIdle(true);
        poolConfig.setBlockWhenExhausted(true);
        poolConfig.setMaxWaitMillis(20000);
        poolConfig.setMinEvictableIdleTimeMillis(Duration.ofMinutes(10).toMillis());
        pool = new JedisPool(poolConfig, "ec2-13-58-78-162.us-east-2.compute.amazonaws.com", 6379, 20000, 1000, null, 0, null, false, null, null, null);
    }

    static {
        initPool();
    }

    public static Jedis getJedis() {
        return pool.getResource();
    }
}

