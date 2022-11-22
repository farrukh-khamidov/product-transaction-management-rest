package com.example.producttransactionmanagementrest.dto;

import lombok.Data;

import java.util.List;

@Data
public class RequestReqDto {
    private String requestId;
    private String placeName;
    private String productId;
}
