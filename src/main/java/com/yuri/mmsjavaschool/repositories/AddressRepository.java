package com.yuri.mmsjavaschool.repositories;

import com.yuri.mmsjavaschool.models.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Integer> {
}
