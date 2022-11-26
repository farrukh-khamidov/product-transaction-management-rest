package com.example.producttransactionmanagementrest.controllers;

import com.example.producttransactionmanagementrest.dto.OfferReqDto;
import com.example.producttransactionmanagementrest.dto.TransactionReqDto;
import com.example.producttransactionmanagementrest.exceptions.ApiException;
import com.example.producttransactionmanagementrest.exceptions.ErrorResponse;
import com.example.producttransactionmanagementrest.service.TransactionService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/transactions")
@RequiredArgsConstructor
@Slf4j
public class TransactionController {

    private final TransactionService transactionService;

    @PostMapping
    public ResponseEntity addTransaction(@RequestBody TransactionReqDto reqDto) {
        log.info("addTransaction request: {}", reqDto);

        return ResponseEntity.ok(transactionService.addTransaction(reqDto));
    }


}
