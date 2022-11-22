package com.example.producttransactionmanagementrest.controllers;

import com.example.producttransactionmanagementrest.dto.PlaceResDto;
import com.example.producttransactionmanagementrest.dto.RegionReqDto;
import com.example.producttransactionmanagementrest.entity.Region;
import com.example.producttransactionmanagementrest.service.RegionService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/regions")
@RequiredArgsConstructor
@Slf4j
public class RegionController {

    private final RegionService regionService;

    @PostMapping
    public  List<PlaceResDto> save(@RequestBody RegionReqDto regionDto) {
        log.info("addRegion request: {}", regionDto);
        return regionService.saveRegionWithPlaces(regionDto);
    }

    @GetMapping
    public List<Region> getAll() {
        return regionService.findAll();
    }
}
