package com.example.producttransactionmanagementrest.repository;

import com.example.producttransactionmanagementrest.entity.Region;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RegionRepository extends JpaRepository<Region, Long> {
    List<Region> findAllByNameIn(List<String> names);
    Region findFirstByName(String name);

}
