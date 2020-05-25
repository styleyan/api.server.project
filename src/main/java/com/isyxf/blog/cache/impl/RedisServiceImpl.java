package com.isyxf.blog.cache.impl;

import com.isyxf.blog.cache.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 * redis 常用操作
 * @Author Y.Jer
 */
@Component
public class RedisServiceImpl implements RedisService {
    /**
     * 定义key名前缀
     */
    private final static String REDIS_PREFIX= "BLOG_";
    private final static String COMMON_SPLIT_CHAR = ".";

    @Autowired
    private RedisTemplate redisTemplate;

    /**
     * 普通获取缓存
     * @param key
     * @return
     */
    @Override
    public String get(String key) {
        return key == null ? null : (String) redisTemplate.opsForValue().get(prefix(key));
    }

    /**
     * 普通设置缓存
     * @param key
     * @param value
     * @return
     */
    @Override
    public boolean set(String key, String value) {
        if (key != null && value != null) {
            try {
                redisTemplate.opsForValue().set(prefix(key), value);
                return true;
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
        return false;
    }

    /**
     * 普通设置缓存，并添加过期时间
     * @param key key 键
     * @param value 值
     * @param time 时间(秒) time 要大于0 如果time小于等于0 将设置无限期
     * @return
     */
    @Override
    public boolean set(String key, String value, long time) {
        try {
            if (time > 0) {
                redisTemplate.opsForValue().set(prefix(key), value, time, TimeUnit.SECONDS);
            } else {
                redisTemplate.opsForValue().set(prefix(key), value);
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * 删除key
     * @param key
     * @return
     */
    @Override
    public boolean del(String key) {
        if (key != null) {
            redisTemplate.delete(key);
        }
        return false;
    }

    /**
     * 统一设置key名前缀
     * @param key
     * @return
     */
    private String prefix(String key) {
        return new StringBuffer(64).append(REDIS_PREFIX).append(COMMON_SPLIT_CHAR).append(key).toString();
    }
}
