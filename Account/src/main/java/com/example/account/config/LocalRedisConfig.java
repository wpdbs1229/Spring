package com.example.account.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import redis.embedded.RedisServer;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Configuration
public class LocalRedisConfig {

    @Value("${spring.redis.port}")
    private int redisPort;

    private RedisServer redisServer;

    @PostConstruct
    public void startRedis(){
        redisServer = new RedisServer(redisPort);
        redisServer.start(); //레디스를 별도의 인스턴스로 시작시켜줌
    }

    @PreDestroy
    public void stopRedis(){
        if (redisServer != null){
            redisServer.stop();
        }
    }

}
