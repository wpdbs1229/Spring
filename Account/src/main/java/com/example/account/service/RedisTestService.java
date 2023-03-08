package com.example.account.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Slf4j
@Service
@RequiredArgsConstructor
public class RedisTestService {

    //Bean과 이름이 같으므로 주입됨
    private final RedissonClient redisClient;

    public String getLock(){
        RLock lock = redisClient.getLock("sampleLock");

        try{
            boolean isLock = lock.tryLock(1,3, TimeUnit.SECONDS);
            if (!isLock){
                log.error("=====Lock acquisition faild======");
                return "Lock failed";
            }
        } catch (Exception e){
            log.error("Redis lock failed");
        }

        return "Lock success";
    }
}
