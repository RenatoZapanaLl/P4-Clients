package com.example.ClientsService.Controller;

import com.example.ClientsService.domain.Clients;
import com.example.ClientsService.repository.ClientsRepository;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class ClientsController {
    private ClientsRepository studentRepository;

    public ClientsController(ClientsRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @GetMapping("/clients")
    public Map<String, Clients> findAll() {
        return studentRepository.findAll();
    }

    @GetMapping("/clients/{id}")
    public Clients findById(@PathVariable String id) {
        return studentRepository.findById(id);
    }

    @PostMapping("/clients")
    public void createClients(@RequestBody Clients clients) {
        studentRepository.save(clients);
    }

    @DeleteMapping("/clients/{id}")
    public void deleteClients(@PathVariable String id) {
        studentRepository.delete(id);
    }

}
