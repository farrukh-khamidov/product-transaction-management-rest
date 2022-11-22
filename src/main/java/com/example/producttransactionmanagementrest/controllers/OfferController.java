package com.example.producttransactionmanagementrest.controllers;

import com.example.producttransactionmanagementrest.dto.OfferReqDto;
import com.example.producttransactionmanagementrest.dto.RequestReqDto;
import com.example.producttransactionmanagementrest.exceptions.ApiException;
import com.example.producttransactionmanagementrest.exceptions.ErrorResponse;
import com.example.producttransactionmanagementrest.service.OfferService;
import com.example.producttransactionmanagementrest.service.RequestService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/offers")
@RequiredArgsConstructor
@Slf4j
public class OfferController {

    private final OfferService offerService;

    @PostMapping
    public ResponseEntity addOffer(@RequestBody OfferReqDto reqDto) {
        log.info("addRequest request: {}", reqDto);

        try {
            return ResponseEntity.ok(offerService.addOffer(reqDto));
        } catch (ApiException e) {
            return new ResponseEntity<>(new ErrorResponse(e.getCode(), e.getMessage()), e.getHttpStatus());
        }
    }


}
