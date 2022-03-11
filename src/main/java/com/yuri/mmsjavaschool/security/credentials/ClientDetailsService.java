//package com.yuri.mmsjavaschool.security.credentials;
//
//import com.yuri.mmsjavaschool.services.impls.ClientServiceImpl;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//
//import java.util.Optional;
//
//@Service
//public class ClientDetailsService implements UserDetailsService {
//
//    private final ClientServiceImpl service;
//
//    public ClientDetailsService(ClientServiceImpl service) {
//        this.service = service;
//    }
//
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        return Optional.ofNullable(service.getClientByUsername(username))
//                .map(client -> User.withUsername(client.getUsername())
//                        .password(client.getPassword())
//                        .roles(client.getRole().name().split("_")[1])
//                        .build())
//                .orElseThrow(() -> new UsernameNotFoundException(
//                        String.format("Client with username: %s was not found.", username)));
//    }
//}
