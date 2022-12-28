package com.baoan.sk;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

/**
 * @author wang xiao
 * date 2022/12/28
 */
@Component
public class DemoService {


    private RedisService<String> redisService;

    private String goodKey = "good";

    public Boolean order(String uid){
        String s = redisService.removeQueueLastEntry(goodKey);
        if (StringUtils.isEmpty(s)){
            return false;
        }
        return true;
    }

    @Autowired
    public void setRedisService(RedisService<String> redisService) {
        this.redisService = redisService;
    }
}
