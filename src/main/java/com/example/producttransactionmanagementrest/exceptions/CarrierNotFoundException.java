package com.example.producttransactionmanagementrest.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class CarrierNotFoundException extends ApiException {

    public CarrierNotFoundException() {
        super(StatusEnum.ERR_1003);
    }

}