package com.example.producttransactionmanagementrest.service.impl;

import com.example.producttransactionmanagementrest.dto.CarrierReqDto;
import com.example.producttransactionmanagementrest.dto.CarrierResDto;
import com.example.producttransactionmanagementrest.dto.RegionResDto;
import com.example.producttransactionmanagementrest.entity.Carrier;
import com.example.producttransactionmanagementrest.entity.Region;
import com.example.producttransactionmanagementrest.generics.JpaServiceImpl;
import com.example.producttransactionmanagementrest.repository.CarrierRepository;
import com.example.producttransactionmanagementrest.repository.RegionRepository;
import com.example.producttransactionmanagementrest.service.CarrierService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CarrierServiceImpl extends JpaServiceImpl<Carrier, Long> implements CarrierService {

    private final RegionRepository regionRepository;
    private final CarrierRepository carrierRepository;

    @Override
    public List<RegionResDto> saveCarrierWithRegions(CarrierReqDto carrierDto) {
        List<Region> regions = regionRepository.findAllByNameIn(carrierDto.getRegions());
        Carrier carrier = new Carrier();
        carrier.setName(carrierDto.getName());
        carrier.setRegions(regions);

        save(carrier);
        return regions.stream().map(region -> new RegionResDto(region.getId(), region.getName())).sorted(Comparator.comparing(RegionResDto::getName)).collect(Collectors.toList());
    }

    @Override
    public List<CarrierResDto> getCarriersForRegion(String regionName) {
        List<Carrier> carriers = carrierRepository.findAllByRegions_name(regionName);
//        List<Carrier> carriers = carrierRepository.findAllByRegions(regionRepository.findFirstByName(regionName));
        return carriers.stream().map(carrier -> new CarrierResDto(carrier.getId(), carrier.getName()))
                .sorted(Comparator.comparing(CarrierResDto::getName)).collect(Collectors.toList());
    }

    @Override
    public JpaRepository<Carrier, Long> getRepository() {
        return carrierRepository;
    }
}
