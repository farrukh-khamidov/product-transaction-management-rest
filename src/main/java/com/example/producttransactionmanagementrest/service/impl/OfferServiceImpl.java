package com.example.producttransactionmanagementrest.service.impl;

import com.example.producttransactionmanagementrest.dto.OfferReqDto;
import com.example.producttransactionmanagementrest.entity.Offer;
import com.example.producttransactionmanagementrest.entity.Place;
import com.example.producttransactionmanagementrest.exceptions.OfferAlreadyExistsException;
import com.example.producttransactionmanagementrest.exceptions.PlaceNotFoundException;
import com.example.producttransactionmanagementrest.generics.JpaServiceImpl;
import com.example.producttransactionmanagementrest.repository.OfferRepository;
import com.example.producttransactionmanagementrest.repository.PlaceRepository;
import com.example.producttransactionmanagementrest.service.OfferService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class OfferServiceImpl extends JpaServiceImpl<Offer, Long> implements OfferService {

    private final PlaceRepository placeRepository;
    private final OfferRepository offerRepository;

    @Override
    public Offer addOffer(OfferReqDto reqDto) {
        Optional<Place> optional = placeRepository.findByName(reqDto.getPlaceName());

        if (optional.isEmpty()) throw new PlaceNotFoundException();
        if (offerRepository.existsByOfferId(reqDto.getOfferId())) throw new OfferAlreadyExistsException();

        Offer offer = Offer.builder().offerId(reqDto.getOfferId()).productId(reqDto.getProductId()).place(optional.get()).build();
        return save(offer);
    }

    @Override
    public JpaRepository<Offer, Long> getRepository() {
        return offerRepository;
    }
}
