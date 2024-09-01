package com.shawon.marketplace.services;

import com.shawon.marketplace.entities.Transaction;
import com.shawon.marketplace.entities.Product;
import com.shawon.marketplace.entities.User;
import com.shawon.marketplace.repositories.TransactionRepository;
import com.shawon.marketplace.repositories.ProductRepository;
import com.shawon.marketplace.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionService {

    @Autowired
    private TransactionRepository transactionRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private UserRepository userRepository;

    public List<Transaction> getAllTransactions() {
        return transactionRepository.findAll();
    }

    public Transaction processTransaction(Long productId, Long buyerId) {
        Product product = productRepository.findById(productId).orElseThrow(() -> new RuntimeException("Product not found"));
        User buyer = userRepository.findById(buyerId).orElseThrow(() -> new RuntimeException("Buyer not found"));
        Transaction transaction = new Transaction();
        transaction.setProduct(product);
        transaction.setBuyer(buyer);
        transaction.setAmount(product.getPrice());
        return transactionRepository.save(transaction);
    }
}