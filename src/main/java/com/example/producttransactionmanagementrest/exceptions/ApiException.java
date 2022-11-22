package com.example.producttransactionmanagementrest.exceptions;

import org.springframework.http.HttpStatus;

public class ApiException extends RuntimeException {

    private int code;
    private HttpStatus httpStatus;

    public ApiException(String message) {
        super(message);
    }

    public ApiException(HttpStatus httpStatus, int code, String message) {
        super(message);
        this.httpStatus = httpStatus;
        this.code = code;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public int getCode() {
        return code;
    }
}
