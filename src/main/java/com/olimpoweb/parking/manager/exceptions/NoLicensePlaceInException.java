package com.olimpoweb.parking.manager.exceptions;

public class NoLicensePlaceInException extends RuntimeException{

    public NoLicensePlaceInException() {
    }
    
    public NoLicensePlaceInException(String message) {
        super(message);
    }

}
