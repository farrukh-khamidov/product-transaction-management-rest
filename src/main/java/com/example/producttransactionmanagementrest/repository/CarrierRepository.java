package com.example.producttransactionmanagementrest.repository;

import com.example.producttransactionmanagementrest.entity.Carrier;
import com.example.producttransactionmanagementrest.entity.Region;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CarrierRepository extends JpaRepository<Carrier, Long> {
    List<Carrier> findAllByRegions_name(String regionName);
    List<Carrier> findAllByRegions(Region regionName);

    Optional<Carrier> findByName(String name);
}
