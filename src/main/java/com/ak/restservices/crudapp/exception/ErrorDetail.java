package com.ak.restservices.crudapp.exception;

import java.util.Date;

public class ErrorDetail {
    private Date timestamp;
    private String message;
    private String details;

    public ErrorDetail(String message, String details) {
        this.timestamp = new Date();
        this.message = message;
        this.details = details;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public String getMessage() {
        return message;
    }

    public String getDetails() {
        return details;
    }

    @Override
    public String toString() {
        return "ErrorDetail{" +
                "timestamp=" + timestamp +
                ", message='" + message + '\'' +
                ", details='" + details + '\'' +
                '}';
    }
}
