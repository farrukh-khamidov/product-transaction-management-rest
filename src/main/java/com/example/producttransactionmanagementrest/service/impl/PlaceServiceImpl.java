package com.example.producttransactionmanagementrest.service.impl;

import com.example.producttransactionmanagementrest.entity.Place;
import com.example.producttransactionmanagementrest.repository.PlaceRepository;
import com.example.producttransactionmanagementrest.service.PlaceService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PlaceServiceImpl implements PlaceService {

    private final PlaceRepository placeRepository;

    @Override
    public List<Place> findAll() {
        return placeRepository.findAll();
    }

    @Override
    public Place save(Place place) {
        return placeRepository.save(place);
    }
}
