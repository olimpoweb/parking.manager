package com.olimpoweb.parking.manager.exceptions;

public class LicensePlateAlreadyInException extends RuntimeException{

    public LicensePlateAlreadyInException() {
    }
    
    public LicensePlateAlreadyInException(String message) {
        super(message);
    }

}
