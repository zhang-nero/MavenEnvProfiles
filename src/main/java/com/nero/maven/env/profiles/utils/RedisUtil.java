package com.nero.maven.env.profiles.utils;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

/**
 * @author Nero
 * @since 2018-06-26 16:25
 */
public class RedisUtil {

    private static JedisPool pool;

    public static void setJedisPool(JedisPool jedisPool){
        pool = jedisPool;
    }

    public static Jedis getJedis(){
        return pool.getResource();
    }

    public static void releaseJedis(Jedis jedis){
        if (jedis != null){
            jedis.close();
        }
    }

    public static void set(String key, String value){
        Jedis jedis = null;
        try{
            jedis = getJedis();
            jedis.set(key, value);
        }finally {
            releaseJedis(jedis);
        }
    }

    public static String get(String key){
        Jedis jedis = null;
        try{
            jedis = getJedis();
            return jedis.get(key);
        }finally {
            releaseJedis(jedis);
        }
    }

}
