package com.nero.maven.env.profiles.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * @author Nero
 * @since 2018-06-26 16:25
 */
@Setter
@Getter
@Configuration
public class RedisConfig {
    /**
     * Redis服务器连接地址
     */
    @Value("${redis.host}")
    private String redisHost;
    /**
     * Redis服务器连接端口
     */
    @Value("${redis.port}")
    private Integer redisPort;
    /**
     * Redis服务器连接密码（默认为空）
     */
    @Value("${redis.password}")
    private String redisPassword;
    /**
     * Redis数据库索引（默认为0）
     */
    @Value("${redis.database}")
    private Integer redisDatabase;
    /**
     * 连接超时时间（毫秒）
     */
    @Value("${redis.timeout}")
    private Integer redisTimeout;
    /**
     * 连接池最大连接数（使用负值表示没有限制）
     */
    @Value("${redis.jedis.pool.max.active}")
    private Integer redisJedisPoolMaxActive;
    /**
     * 连接池最大阻塞等待时间（使用负值表示没有限制）
     */
    @Value("${redis.jedis.pool.max.wait}")
    private Long redisJedisPoolMaxWait;
    /**
     * jedis超时
     */
    @Value("${redis.jedis.shutdown.timeout}")
    private Long redisJedisShutdownTimeout;
    /**
     * 连接池中的最大空闲连接
     */
    @Value("${redis.jedis.pool.max.idle}")
    private Integer redisJedisPoolMaxIdle;
    /**
     * 连接池中的最小空闲连接
     */
    @Value("${redis.jedis.pool.min.idle}")
    private Integer redisJedisPoolMinIdle;

    @Bean
    public JedisPool jedisPoolFactory(){
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        jedisPoolConfig.setMaxTotal(redisJedisPoolMaxActive);
        jedisPoolConfig.setMaxWaitMillis(redisJedisPoolMaxWait);
        jedisPoolConfig.setEvictorShutdownTimeoutMillis(redisJedisShutdownTimeout);
        jedisPoolConfig.setMaxIdle(redisJedisPoolMaxIdle);
        jedisPoolConfig.setMinIdle(redisJedisPoolMinIdle);
        JedisPool jedisPool = new JedisPool(jedisPoolConfig, redisHost, redisPort, redisTimeout, redisPassword,redisDatabase);
        return jedisPool;
    }

}
