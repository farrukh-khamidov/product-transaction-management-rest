package com.example.producttransactionmanagementrest.controllers;

import com.example.producttransactionmanagementrest.entity.Place;
import com.example.producttransactionmanagementrest.service.PlaceService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/places")
@RequiredArgsConstructor
public class PlaceController {

    private final PlaceService placeService;

    @GetMapping
    public List<Place> getAll() {
        return placeService.findAll();
    }
}
