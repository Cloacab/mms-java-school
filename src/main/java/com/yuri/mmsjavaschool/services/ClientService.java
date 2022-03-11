package com.yuri.mmsjavaschool.services;

import com.yuri.mmsjavaschool.models.Client;
import com.yuri.mmsjavaschool.models.dto.ClientDto;
import com.yuri.mmsjavaschool.services.impls.UserAlreadyExistException;

import java.util.List;

public interface ClientService {
    Client getClientByUsername(String login);
    Client getClientById(Integer id);
    List<Client> getAllClients();
    void addClient(Client client);
    Client registerNewClient(ClientDto clientDto) throws UserAlreadyExistException;
}
