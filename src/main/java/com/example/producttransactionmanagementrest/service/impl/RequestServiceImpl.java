package com.example.producttransactionmanagementrest.service.impl;

import com.example.producttransactionmanagementrest.dto.RequestReqDto;
import com.example.producttransactionmanagementrest.entity.Place;
import com.example.producttransactionmanagementrest.entity.Request;
import com.example.producttransactionmanagementrest.exceptions.ApiException;
import com.example.producttransactionmanagementrest.repository.PlaceRepository;
import com.example.producttransactionmanagementrest.repository.RequestRepository;
import com.example.producttransactionmanagementrest.service.RequestService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RequestServiceImpl implements RequestService {

    private final PlaceRepository placeRepository;
    private final RequestRepository requestRepository;

    @Override
    public Request addRequest(RequestReqDto reqDto) {
        Optional<Place> optional = placeRepository.findByName(reqDto.getPlaceName());

        if (optional.isEmpty()) throw new ApiException(HttpStatus.NOT_FOUND, 1001, "Place not found with name " + reqDto.getPlaceName());
        if (requestRepository.existsByRequestId(reqDto.getRequestId())) throw new ApiException(HttpStatus.BAD_REQUEST, 1002, "Request already exists");

        Request request = Request.builder().requestId(reqDto.getRequestId()).productId(reqDto.getProductId()).place(optional.get()).build();
        return requestRepository.save(request);
    }

//    @Override
//    public JsonNode addRequest(RequestReqDto reqDto) {
//        Optional<Place> optional = placeRepository.findByName(reqDto.getPlaceName());
//        if (optional.isEmpty()) {
//            return mapper.convertValue(new ErrorResponse(1001, "Place not found with name " + reqDto.getPlaceName()), JsonNode.class);
//        }
//        Request request = Request.builder().requestId(reqDto.getRequestId()).productId(reqDto.getProductId()).place(optional.get()).build();
//        return mapper.convertValue(requestRepository.save(request), JsonNode.class);
//    }
}
