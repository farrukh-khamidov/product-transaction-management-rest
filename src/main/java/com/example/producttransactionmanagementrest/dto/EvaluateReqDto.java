package com.example.producttransactionmanagementrest.dto;

import lombok.Data;

@Data
public class EvaluateReqDto {
    private String transactionId;
    private int score;
}
