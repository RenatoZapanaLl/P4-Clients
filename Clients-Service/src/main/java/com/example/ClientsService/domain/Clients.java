package com.example.ClientsService.domain;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

import java.io.Serializable;

@Data
@RedisHash("Client")
public class Clients implements Serializable {
    private  String NamesClients;
    private  String DNI;
    private  String NumberPhone;
}
