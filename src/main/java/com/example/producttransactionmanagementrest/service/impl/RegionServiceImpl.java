package com.example.producttransactionmanagementrest.service.impl;

import com.example.producttransactionmanagementrest.dto.PlaceResDto;
import com.example.producttransactionmanagementrest.dto.RegionReqDto;
import com.example.producttransactionmanagementrest.entity.Place;
import com.example.producttransactionmanagementrest.entity.Region;
import com.example.producttransactionmanagementrest.generics.JpaServiceImpl;
import com.example.producttransactionmanagementrest.repository.PlaceRepository;
import com.example.producttransactionmanagementrest.repository.RegionRepository;
import com.example.producttransactionmanagementrest.service.RegionService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RegionServiceImpl extends JpaServiceImpl<Region, Long> implements RegionService {

    private final RegionRepository regionRepository;
    private final PlaceRepository placeRepository;


    @Override
    public List<PlaceResDto> saveRegionWithPlaces(RegionReqDto regionDto) {
        Region region = new Region(regionDto.getName());
        region = save(region);
        final long regionId = region.getId();
        regionDto.getPlaces().forEach(placeName -> {
            if (!placeRepository.existsByName(placeName)) {
                placeRepository.save(new Place(placeName, regionId));
            }
        });

        List<Place> places = placeRepository.findAllByRegionId(regionId);

        return places.stream().sorted(Comparator.comparing(Place::getName)).map(place -> new PlaceResDto(place.getId(), place.getName())).collect(Collectors.toList());
    }

    @Override
    public JpaRepository<Region, Long> getRepository() {
        return regionRepository;
    }
}
