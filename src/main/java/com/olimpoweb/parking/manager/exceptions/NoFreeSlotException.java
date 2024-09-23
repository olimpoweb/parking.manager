package com.olimpoweb.parking.manager.exceptions;

public class NoFreeSlotException extends RuntimeException{

    public NoFreeSlotException() {
    }
    
    public NoFreeSlotException(String message) {
        super(message);
    }

}
