package com.example.producttransactionmanagementrest.service;

import com.example.producttransactionmanagementrest.dto.RequestReqDto;
import com.example.producttransactionmanagementrest.entity.Request;
import com.fasterxml.jackson.databind.JsonNode;


public interface RequestService {

    Request addRequest(RequestReqDto reqDto);

//    JsonNode addRequest(RequestReqDto reqDto);
}
