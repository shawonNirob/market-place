package com.shawon.marketplace.repositories;

import com.shawon.marketplace.entities.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {
}