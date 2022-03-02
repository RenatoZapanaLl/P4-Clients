package com.example.ClientsService.repository;

import com.example.ClientsService.domain.Clients;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.Map;
import java.util.UUID;

@Repository
public class ClientsRepository implements RedisRepository{
    private  static final String KEY = "Client";

    @Autowired
    private RedisTemplate<String,Clients> redisTemplate;
    private HashOperations hashOperations;

    public ClientsRepository(RedisTemplate<String, Clients> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    @PostConstruct
    private  void  init(){
        hashOperations = redisTemplate.opsForHash();
    }

    @Override
    public Map<String, Clients> findAll() {
        return hashOperations.entries(KEY);
    }

    @Override
    public Clients findById(String id) {
        return (Clients) hashOperations.get(KEY,id);
    }

    @Override
    public void save(Clients clients) {
        hashOperations.put(KEY, UUID.randomUUID().toString(),clients);
        //hashOperations.put(KEY, UUID.randomUUID().toString(),clients);
    }

    @Override
    public void delete(String id) {
        hashOperations.delete(KEY,id);
    }
}
