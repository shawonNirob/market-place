package com.shawon.marketplace.controllers;

import com.shawon.marketplace.entities.Transaction;
import com.shawon.marketplace.services.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/transactions")
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    @GetMapping
    public List<Transaction> getAllTransactions() {
        return transactionService.getAllTransactions();
    }

    @PostMapping
    public ResponseEntity<Transaction> processTransaction(@RequestParam Long productId, @RequestParam Long buyerId) {
        Transaction transaction = transactionService.processTransaction(productId, buyerId);
        return ResponseEntity.ok(transaction);
    }
}