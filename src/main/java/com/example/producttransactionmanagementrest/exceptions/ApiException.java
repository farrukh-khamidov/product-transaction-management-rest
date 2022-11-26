package com.example.producttransactionmanagementrest.exceptions;

public class ApiException extends RuntimeException {

    private StatusEnum statusEnum;

    public ApiException(String message) {
        super(message);
    }

    public ApiException(StatusEnum statusEnum) {
        super(statusEnum.getMessage());
        this.statusEnum = statusEnum;
    }

    public StatusEnum getStatusEnum() {
        return statusEnum;
    }
}
