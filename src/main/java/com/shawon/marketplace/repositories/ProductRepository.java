package com.shawon.marketplace.repositories;

import com.shawon.marketplace.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}