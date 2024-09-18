package com.olimpoweb.parking.manager.exceptions;

public class ParkException extends RuntimeException{

    public ParkException() {
    }
    
    public ParkException(String message) {
        super(message);
    }

}
