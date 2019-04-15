package com.ming.ljs.util;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

/**
 * created by ZMX
 * Date 2019/4/12 Time 21:30
 */
public class JedisUtil {
    static JedisPool jedisPool = new JedisPool();

    public static Jedis getJedisFromPool(){
        Jedis resource = jedisPool.getResource();
        return resource;
    }
}
