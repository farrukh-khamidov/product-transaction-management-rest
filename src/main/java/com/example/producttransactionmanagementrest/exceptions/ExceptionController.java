package com.example.producttransactionmanagementrest.exceptions;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionController {

    @ExceptionHandler(ApiException.class)
    public ResponseEntity<ErrorResponse> handleApiException(ApiException e) {

        return ResponseEntity
                .status(e.getStatusEnum().getHttpStatus())
                .body(new ErrorResponse(e.getStatusEnum().getCode(), e.getStatusEnum().getMessage()));
    }

}
