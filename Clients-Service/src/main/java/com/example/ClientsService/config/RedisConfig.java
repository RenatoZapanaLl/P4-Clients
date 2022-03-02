package com.example.ClientsService.config;

import com.example.ClientsService.domain.Clients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

@Configuration
public class RedisConfig {
    @Bean
    JedisConnectionFactory jedisConnectionFactory()
    {
        return  new JedisConnectionFactory();
    }
    @Bean
    RedisTemplate<String,Clients> redisTemplate() {
        final RedisTemplate<String, Clients> redisTemplate=new RedisTemplate<>();
        redisTemplate.setConnectionFactory(jedisConnectionFactory());
        return  redisTemplate;
    }
}
