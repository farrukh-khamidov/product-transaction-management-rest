package com.example.producttransactionmanagementrest.service;


import com.example.producttransactionmanagementrest.dto.CarrierReqDto;
import com.example.producttransactionmanagementrest.dto.CarrierResDto;
import com.example.producttransactionmanagementrest.dto.RegionResDto;

import java.util.List;

public interface CarrierService {

    List<RegionResDto> saveCarrierWithRegions(CarrierReqDto carrierDto);

    List<CarrierResDto> getCarriersForRegion(String regionName);
}
