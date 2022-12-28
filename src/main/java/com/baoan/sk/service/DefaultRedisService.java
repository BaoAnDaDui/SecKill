package com.baoan.sk.service;

import com.baoan.sk.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.util.Collection;

/**
 * @author wang xiao
 * date 2022/12/28
 */
@Service
public class DefaultRedisService implements RedisService<String> {

    private StringRedisTemplate redisTemplate;

    @Autowired
    public void setRedisTemplate(StringRedisTemplate redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    @Override
    public void add(String key, String value, Duration duration) {
        redisTemplate.opsForValue().set(key, value, duration);
    }

    @Override
    public String get(String key) {
        return redisTemplate.opsForValue().get(key);
    }

    @Override
    public Boolean remove(String key) {
        return redisTemplate.delete(key);
    }

    @Override
    public String removeQueueLastEntry(String key) {
        return redisTemplate.opsForList().rightPop(key);
    }

    @Override
    public Long addQueueFirstEntry(String key, Collection<String> args) {
        return redisTemplate.opsForList().leftPushAll(key,args);
    }
}
