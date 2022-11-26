package com.example.producttransactionmanagementrest.exceptions;

import org.springframework.http.HttpStatus;

public enum StatusEnum {
    ERR_1001(HttpStatus.NOT_FOUND, 1001, "Place Not Found"),
    ERR_1002(HttpStatus.BAD_REQUEST, 1002, "Request already exists"),
    ERR_1003(HttpStatus.NOT_FOUND, 1003, "Carrier not found"),
    ERR_1004(HttpStatus.NOT_FOUND, 1004, "Offer not found"),
    ERR_1005(HttpStatus.NOT_FOUND, 1005, "Request not found"),
    ERR_1006(HttpStatus.BAD_REQUEST, 1006, "Transaction already exists"),
    ERR_1007(HttpStatus.BAD_REQUEST, 1006, "Transaction already exists"),
    ERR_1008(HttpStatus.BAD_REQUEST, 1008, "Offer and request product ids must be same"),
    ERR_1009(HttpStatus.BAD_REQUEST, 1009, "This carrier should serve both the delivery and pickup places"),
    ERR_1010(HttpStatus.BAD_REQUEST, 1010, "Offer already exists")
    ;

    private HttpStatus httpStatus;
    private int code;
    private String message;

    StatusEnum(HttpStatus httpStatus, int code, String message) {
       this.httpStatus = httpStatus;
       this.code = code;
       this.message = message;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
