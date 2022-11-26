package com.example.producttransactionmanagementrest.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class TransactionAlreadyExistsException extends ApiException {

    public TransactionAlreadyExistsException() {
        super(StatusEnum.ERR_1006);
    }
}
