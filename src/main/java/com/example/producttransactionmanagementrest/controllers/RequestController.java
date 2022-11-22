package com.example.producttransactionmanagementrest.controllers;

import com.example.producttransactionmanagementrest.dto.RequestReqDto;
import com.example.producttransactionmanagementrest.exceptions.ErrorResponse;
import com.example.producttransactionmanagementrest.exceptions.ApiException;
import com.example.producttransactionmanagementrest.service.RequestService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/requests")
@RequiredArgsConstructor
@Slf4j
public class RequestController {

    private final RequestService requestService;

    @PostMapping
    public ResponseEntity addRequest(@RequestBody RequestReqDto reqDto) {
        log.info("addRequest request: {}", reqDto);

        try {
            return ResponseEntity.ok(requestService.addRequest(reqDto));
        } catch (ApiException e) {
            return new ResponseEntity<>(new ErrorResponse(e.getCode(), e.getMessage()), e.getHttpStatus());
        }
    }

//    @PostMapping
//    public ResponseEntity addRequest(@RequestBody RequestReqDto reqDto) {
//        log.info("addRequest request: {}", reqDto);
//        return ResponseEntity.ok(requestService.addRequest(reqDto));
//    }

}
