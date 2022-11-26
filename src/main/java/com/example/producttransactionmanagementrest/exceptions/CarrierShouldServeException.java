package com.example.producttransactionmanagementrest.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class CarrierShouldServeException extends ApiException {

    public CarrierShouldServeException() {
        super(StatusEnum.ERR_1009);
    }

}
