package com.example.producttransactionmanagementrest.repository;

import com.example.producttransactionmanagementrest.entity.Offer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface OfferRepository extends JpaRepository<Offer, Long> {
    boolean existsByOfferId(String offerId);
    Optional<Offer> findByOfferId(String offerId);
}
