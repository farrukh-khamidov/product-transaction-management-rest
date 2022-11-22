package com.example.producttransactionmanagementrest.service;


import com.example.producttransactionmanagementrest.dto.PlaceResDto;
import com.example.producttransactionmanagementrest.dto.RegionReqDto;
import com.example.producttransactionmanagementrest.entity.Region;

import java.util.List;

public interface RegionService {
    List<Region> findAll();

    Region save(Region region);

    List<PlaceResDto> saveRegionWithPlaces(RegionReqDto regionDto);
}
