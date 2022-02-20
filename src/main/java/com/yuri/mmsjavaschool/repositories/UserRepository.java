package com.yuri.mmsjavaschool.repositories;

import com.yuri.mmsjavaschool.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
}
