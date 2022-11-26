package com.example.producttransactionmanagementrest.service;


import com.example.producttransactionmanagementrest.dto.PlaceResDto;
import com.example.producttransactionmanagementrest.dto.RegionReqDto;
import com.example.producttransactionmanagementrest.entity.Region;
import com.example.producttransactionmanagementrest.generics.JpaService;

import java.util.List;

public interface RegionService extends JpaService<Region, Long> {

    List<PlaceResDto> saveRegionWithPlaces(RegionReqDto regionDto);
}
