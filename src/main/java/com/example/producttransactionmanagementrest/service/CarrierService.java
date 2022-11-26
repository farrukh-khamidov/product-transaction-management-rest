package com.example.producttransactionmanagementrest.service;


import com.example.producttransactionmanagementrest.dto.CarrierReqDto;
import com.example.producttransactionmanagementrest.dto.CarrierResDto;
import com.example.producttransactionmanagementrest.dto.RegionResDto;
import com.example.producttransactionmanagementrest.entity.Carrier;
import com.example.producttransactionmanagementrest.generics.JpaService;

import java.util.List;

public interface CarrierService extends JpaService<Carrier, Long> {

    List<RegionResDto> saveCarrierWithRegions(CarrierReqDto carrierDto);

    List<CarrierResDto> getCarriersForRegion(String regionName);
}
