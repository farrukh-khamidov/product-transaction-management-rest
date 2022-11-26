package com.example.producttransactionmanagementrest.service;

import com.example.producttransactionmanagementrest.dto.OfferReqDto;
import com.example.producttransactionmanagementrest.entity.Offer;
import com.example.producttransactionmanagementrest.generics.JpaService;


public interface OfferService extends JpaService<Offer, Long> {

    Offer addOffer(OfferReqDto reqDto);

}
