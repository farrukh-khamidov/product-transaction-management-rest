package com.example.producttransactionmanagementrest.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class ProductIdsMusBeSameException extends ApiException {

    public ProductIdsMusBeSameException() {
        super(StatusEnum.ERR_1008);
    }

}
