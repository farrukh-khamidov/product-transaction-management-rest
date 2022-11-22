package com.example.producttransactionmanagementrest.repository;

import com.example.producttransactionmanagementrest.entity.Place;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PlaceRepository extends JpaRepository<Place, Long> {
    boolean existsByName(String name);

    Optional<Place> findByName(String name);
    List<Place> findAllByRegionId(Long regionId);
}
