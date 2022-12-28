package com.baoan.sk;

import java.time.Duration;
import java.util.Collection;
import java.util.Collections;

/**
 * @author wang xiao
 * date 2022/12/28
 */
public interface RedisService<T> {

    /**
     * 添加
     * @param key key
     * @param value value
     * @param duration duration time
     */
    void  add(String key, T value, Duration duration);


    /**
     * 获取
     * @param key key
     * @return value T
     */
    T get(String key);


    /**
     * remove
     * @param key key
     * @return Boolean
     */
    Boolean remove(String key);

    /**
     * 移除 队列末尾的元素
     * @param key key
     * @return T
     */
    T removeQueueLastEntry(String key);


    /**
     * 队列 头部增加数据
     * @param key key
     * @param args entry data
     * @return Boolean
     */
    Long addQueueFirstEntry(String key, Collection<T> args);
}
