package com.isyxf.blog.cache;

/**
 * redis 工具类
 * @author Y.Jer
 * 因为暂时没有太多数据要存储，只实现几个常用的 api
 */
public interface RedisService {
    /**
     * 普通缓存获取
     * @param key key
     * @return
     */
    String get(String key);

    /**
     * 普通缓存放入
     * @param key
     * @param value
     * @return
     */
    boolean set(String key, String value);

    /**
     * 普通缓存放入并设置时间
     * @param key key 键
     * @param value 值
     * @param time 时间(秒) time 要大于0 如果time小于等于0 将设置无限期
     * @return
     */
    boolean set(String key, String value, long time);

    /**
     * 删除key
     * @param key
     * @return
     */
    boolean del(String key);
}
