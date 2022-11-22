package com.example.producttransactionmanagementrest.service;

import com.example.producttransactionmanagementrest.dto.OfferReqDto;
import com.example.producttransactionmanagementrest.entity.Offer;


public interface OfferService {

    Offer addOffer(OfferReqDto reqDto);

}
