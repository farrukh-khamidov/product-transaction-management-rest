package com.example.producttransactionmanagementrest.service.impl;

import com.example.producttransactionmanagementrest.dto.OfferReqDto;
import com.example.producttransactionmanagementrest.dto.RequestReqDto;
import com.example.producttransactionmanagementrest.entity.Offer;
import com.example.producttransactionmanagementrest.entity.Place;
import com.example.producttransactionmanagementrest.entity.Request;
import com.example.producttransactionmanagementrest.exceptions.ApiException;
import com.example.producttransactionmanagementrest.repository.OfferRepository;
import com.example.producttransactionmanagementrest.repository.PlaceRepository;
import com.example.producttransactionmanagementrest.service.OfferService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class OfferServiceImpl implements OfferService {

    private final PlaceRepository placeRepository;
    private final OfferRepository offerRepository;

    @Override
    public Offer addOffer(OfferReqDto reqDto) {
        Optional<Place> optional = placeRepository.findByName(reqDto.getPlaceName());

        if (optional.isEmpty()) throw new ApiException(HttpStatus.NOT_FOUND, 1001, "Place not found with name " + reqDto.getPlaceName());
        if (offerRepository.existsByOfferId(reqDto.getOfferId())) throw new ApiException(HttpStatus.BAD_REQUEST, 1002, "Offer already exists");

        Offer offer = Offer.builder().offerId(reqDto.getOfferId()).productId(reqDto.getProductId()).place(optional.get()).build();
        return offerRepository.save(offer);
    }

}
