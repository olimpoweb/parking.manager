package com.olimpoweb.parking.manager.exceptions;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import lombok.extern.slf4j.Slf4j;


@ControllerAdvice
@Slf4j
public class GlobalHandlerException {

    @ExceptionHandler(value= DataIntegrityViolationException.class)
    public @ResponseBody ErrorResponse DataIntegrityViolationException(DataIntegrityViolationException ex){
        log.error(HttpStatus.CONFLICT + ex.getMessage());
        return new ErrorResponse(HttpStatus.CONFLICT.value(),
                  ex.getMessage(), 
                  "435",
                  "email_already_exists",
                  ex.toString());
    }

    @ExceptionHandler(value= LicensePlateAlreadyInException.class)
    public @ResponseBody ErrorResponse LicensePlateAlreadyInException(LicensePlateAlreadyInException ex){
        log.error(HttpStatus.CONFLICT + ex.getMessage());
        return new ErrorResponse(HttpStatus.CONFLICT.value(),
                  ex.getMessage(), 
                  "455",
                  "car_already_in",
                  ex.toString());
    }

    @ExceptionHandler(value= NoFreeSlotException.class)
    public @ResponseBody ErrorResponse NoFreeSlotException(NoFreeSlotException ex){
        log.error(HttpStatus.CONFLICT + ex.getMessage());
        return new ErrorResponse(HttpStatus.CONFLICT.value(),
                  ex.getMessage(), 
                  "458",
                  "park_is_full",
                  ex.toString());
    }

    @ExceptionHandler(value= NoLicensePlaceInException.class)
    public @ResponseBody ErrorResponse NoLicensePlaceInException(NoLicensePlaceInException ex){
        log.error(HttpStatus.CONFLICT + ex.getMessage());
        return new ErrorResponse(HttpStatus.CONFLICT.value(),
                  ex.getMessage(), 
                  "459",
                  "park_in_not_found",
                  ex.toString());
    }

    @ExceptionHandler(value= GenericException.class)
    public @ResponseBody ErrorResponse GenericException(GenericException ex){
        log.error(HttpStatus.CONFLICT + ex.getMessage());
        return new ErrorResponse(HttpStatus.CONFLICT.value(),
                  ex.getMessage(), 
                  "458",
                  "park_is_full",
                  ex.toString());
    }

}