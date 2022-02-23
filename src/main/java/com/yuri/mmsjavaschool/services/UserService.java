package com.yuri.mmsjavaschool.services;

import com.yuri.mmsjavaschool.models.Client;
import com.yuri.mmsjavaschool.repositories.ClientRepository;
import org.springframework.stereotype.Service;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final ClientRepository clientRepository;

    public UserService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public Client addUser(Client client) {
        Optional<Client> savedUser = clientRepository.findById(client.getId());
        if (savedUser.isEmpty()) {
            client.setCreatedAt(ZonedDateTime.now(ZoneId.of("UTC")));
        }
        return clientRepository.save(client);
    }

    public void addAllUsers(List<Client> clients) {
        List<Client> saveAll = clientRepository.saveAll(clients);
    }

    public Client getUser(Integer id) {
        return clientRepository.findById(id).orElse(null);
    }

}
