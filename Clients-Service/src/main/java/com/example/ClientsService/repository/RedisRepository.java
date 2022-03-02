package com.example.ClientsService.repository;

import com.example.ClientsService.domain.Clients;
import java.util.Map;


public interface RedisRepository {
    Map<String, Clients> findAll();
    Clients findById(String id);
    void save(Clients clients);
    void delete(String id);
}
