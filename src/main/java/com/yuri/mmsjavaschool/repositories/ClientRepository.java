package com.yuri.mmsjavaschool.repositories;

import com.yuri.mmsjavaschool.models.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClientRepository extends JpaRepository<Client, Integer> {
    Optional<Client> findClientByUsername(String username);
    Optional<Client> findByEmail(String email);
    boolean existsByEmail(String email);
}
