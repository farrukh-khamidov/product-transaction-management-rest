package com.example.producttransactionmanagementrest.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class PlaceNotFoundException extends ApiException {
    public PlaceNotFoundException() {
        super(StatusEnum.ERR_1001);
    }
}
