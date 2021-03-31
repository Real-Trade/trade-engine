package com.realtrade.tradeengine.config;

import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import java.net.URI;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.X509Certificate;

public class RedisPoolConfig {
    public static JedisPool getPool() {
        try {
            TrustManager bogusTrustManager = new X509TrustManager() {
                public X509Certificate[] getAcceptedIssuers() {
                    return null;
                }

                public void checkClientTrusted(X509Certificate[] certs, String authType) {
                }

                public void checkServerTrusted(X509Certificate[] certs, String authType) {
                }
            };

            SSLContext sslContext = SSLContext.getInstance("SSL");
            sslContext.init(null, new TrustManager[]{bogusTrustManager}, new java.security.SecureRandom());

            HostnameVerifier bogusHostnameVerifier = (hostname, session) -> true;

            JedisPoolConfig poolConfig = new JedisPoolConfig();
            poolConfig.setMaxTotal(10);
            poolConfig.setMaxIdle(5);
            poolConfig.setMinIdle(1);
            poolConfig.setTestOnBorrow(true);
            poolConfig.setTestOnReturn(true);
            poolConfig.setTestWhileIdle(true);

            return new JedisPool(poolConfig,
                    URI.create("redis://:pae60437eb534bf21c995d83d4660210717ef55a6014d15cef6029c03424bfd7e@ec2-34-235-242-69.compute-1.amazonaws.com:16260"),
                    sslContext.getSocketFactory(),
                    sslContext.getDefaultSSLParameters(),
                    bogusHostnameVerifier);

        } catch (NoSuchAlgorithmException | KeyManagementException e) {
            throw new RuntimeException("Cannot obtain Redis connection!", e);
        }
    }
}


