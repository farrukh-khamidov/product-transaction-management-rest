package com.example.producttransactionmanagementrest.service.impl;

import com.example.producttransactionmanagementrest.entity.Place;
import com.example.producttransactionmanagementrest.generics.CrudServiceImpl;
import com.example.producttransactionmanagementrest.generics.JpaServiceImpl;
import com.example.producttransactionmanagementrest.repository.PlaceRepository;
import com.example.producttransactionmanagementrest.service.PlaceService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PlaceServiceImpl extends JpaServiceImpl<Place, Long> implements PlaceService {

    private final PlaceRepository placeRepository;


    @Override
    public JpaRepository<Place, Long> getRepository() {
        return placeRepository;
    }
}
