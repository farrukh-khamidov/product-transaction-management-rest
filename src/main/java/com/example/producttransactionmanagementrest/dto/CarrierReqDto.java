package com.example.producttransactionmanagementrest.dto;

import lombok.Data;

import java.util.List;

@Data
public class CarrierReqDto {
    private String name;
    private List<String> regions;
}
