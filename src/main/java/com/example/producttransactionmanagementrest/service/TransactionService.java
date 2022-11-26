package com.example.producttransactionmanagementrest.service;

import com.example.producttransactionmanagementrest.dto.EvaluateReqDto;
import com.example.producttransactionmanagementrest.dto.TransactionReqDto;
import com.example.producttransactionmanagementrest.entity.Transaction;


public interface TransactionService {


    Transaction addTransaction(TransactionReqDto reqDto);

    Boolean evaluateTransaction(EvaluateReqDto reqDto);
}
