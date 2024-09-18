package com.olimpoweb.parking.manager.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

@Getter
public class ErrorResponse {
    private int statusCode;
    private String message;
    private ErrorData data;

    public ErrorResponse(int statusCode, String message, String errorCode, String messageCode, String exceptionTrace) {

        this.statusCode = statusCode;
        this.message = message;
        this.data = new ErrorData(errorCode, messageCode, exceptionTrace);
         
    }

    @AllArgsConstructor
    @Data
    public static class ErrorData {

        private String errorCode;
        private String messageCode;
        private String exceptionTrace;
    
    }

}