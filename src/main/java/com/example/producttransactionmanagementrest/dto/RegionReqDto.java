package com.example.producttransactionmanagementrest.dto;

import lombok.Data;

import java.util.List;

@Data
public class RegionReqDto {
    private String name;
    private List<String> places;
}
