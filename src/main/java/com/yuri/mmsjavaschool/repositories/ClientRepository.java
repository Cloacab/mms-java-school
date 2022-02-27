package com.yuri.mmsjavaschool.repositories;

import com.yuri.mmsjavaschool.models.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<Client, Integer> {
    Client getClientByUsername(String username);
}
