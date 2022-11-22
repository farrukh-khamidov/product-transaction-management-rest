package com.example.producttransactionmanagementrest.service;

import com.example.producttransactionmanagementrest.entity.Place;

import java.util.List;

public interface PlaceService {
    List<Place> findAll();

    Place save(Place place);
}
