package com.yuri.mmsjavaschool.services.impls;

import com.yuri.mmsjavaschool.models.Client;
import com.yuri.mmsjavaschool.models.RoleEnum;
import com.yuri.mmsjavaschool.models.dto.ClientDto;
import com.yuri.mmsjavaschool.repositories.ClientRepository;
import com.yuri.mmsjavaschool.services.ClientService;
import lombok.extern.slf4j.Slf4j;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import static com.yuri.mmsjavaschool.utils.Converter.convert;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.List;

@Slf4j
@Service
public class ClientServiceImpl implements ClientService {

    private final ClientRepository clientRepository;
//    private final PasswordEncoder passwordEncoder;

    public ClientServiceImpl(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
//        passwordEncoder = new BCryptPasswordEncoder();
    }

    @Override
    public Client getClientByUsername(String username) {
        return clientRepository.findClientByUsername(username)
                .orElseThrow(() -> new ClientNotFoundException("Client with username: " + username + " was not found"));
    }

    @Override
    public Client getClientById(Integer id) {
        return clientRepository.findById(id)
                .orElseThrow(() -> new ClientNotFoundException("Client with id: " + id + " was not found"));
    }

    @Override
    public List<Client> getAllClients() {
        return clientRepository.findAll();
    }

    @Override
    public void addClient(Client client) {
        if (client.getCreatedAt() == null) {
            client.setCreatedAt(ZonedDateTime.now(ZoneId.of("UTC")));
        }
        clientRepository.save(client);
    }

    @Override
    public Client registerNewClient(ClientDto clientDto) {
        if (emailExist(clientDto.getEmail())) {
            throw new UserAlreadyExistException("There is an account with that email address: "
                    + clientDto.getEmail());
        }
        Client client = convert(dto -> {
            Client newClient = new Client();
            newClient.setUsername(dto.getUsername());
            newClient.setFirstName(dto.getFirstName());
            newClient.setLastName(dto.getLastName());
//            newClient.setPassword(passwordEncoder.encode(dto.getPassword()));
            newClient.setPassword(dto.getPassword());
            newClient.setEmail(dto.getEmail());
            newClient.setBirthDate(dto.getBirthDate());
            newClient.setRole(RoleEnum.USER);
            return newClient;
        }, clientDto);


        return clientRepository.save(client);
    }

    private boolean emailExist(String email) {
        return clientRepository.existsByEmail(email);
    }
}
