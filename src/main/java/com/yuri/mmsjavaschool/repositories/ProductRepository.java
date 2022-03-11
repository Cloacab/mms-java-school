package com.yuri.mmsjavaschool.repositories;

import com.yuri.mmsjavaschool.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Integer> {
}
