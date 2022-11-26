package com.example.producttransactionmanagementrest.repository;

import com.example.producttransactionmanagementrest.entity.Offer;
import com.example.producttransactionmanagementrest.entity.Request;
import com.example.producttransactionmanagementrest.entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {

    Optional<Transaction> findByTransactionId(String transactionId);
    Optional<Transaction> findByOffer(Offer offer);
    Optional<Transaction> findByRequest(Request request);
}
