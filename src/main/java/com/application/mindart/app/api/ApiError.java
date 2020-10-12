package com.application.mindart.app.api;

public class ApiError {

    private String statusCode;
    private String message;

    public ApiError(String statusCode, String message) {
        this.statusCode = statusCode;
        this.message = message;
    }

    public String getStatusCode() {
        return statusCode;
    }

    public String getMessage() {
        return message;
    }

}
