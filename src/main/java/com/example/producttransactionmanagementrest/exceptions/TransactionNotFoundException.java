package com.example.producttransactionmanagementrest.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class TransactionNotFoundException extends ApiException {
    public TransactionNotFoundException() {
        super(StatusEnum.ERR_1001);
    }
}
