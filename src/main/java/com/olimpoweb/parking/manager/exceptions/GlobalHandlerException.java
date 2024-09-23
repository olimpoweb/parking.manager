package com.olimpoweb.parking.manager.exceptions;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import jakarta.servlet.ServletException;
import lombok.extern.slf4j.Slf4j;


@ControllerAdvice
@Slf4j
public class GlobalHandlerException {

    /**
     * DataIntegrityViolationException - Is thrown when the user already exists in the database
     * @param ex
     * @return
     */
    @ExceptionHandler(value= DataIntegrityViolationException.class)
    public @ResponseBody ErrorResponse DataIntegrityViolationException(DataIntegrityViolationException ex){
        log.error(HttpStatus.CONFLICT + ex.getMessage());
        return new ErrorResponse(HttpStatus.CONFLICT.value(),
                  ex.getMessage(), 
                  "435",
                  "email_already_exists",
                  ex.toString());
    }

    /**
     * LicensePlateAlreadyInException - Exception is thrown when the LicensePlate already exists in the parking lot
     * @param ex
     * @return
     */
    @ExceptionHandler(value= LicensePlateAlreadyInException.class)
    public @ResponseBody ErrorResponse LicensePlateAlreadyInException(LicensePlateAlreadyInException ex){
        log.error(HttpStatus.CONFLICT + ex.getMessage());
        return new ErrorResponse(HttpStatus.CONFLICT.value(),
                  ex.getMessage(), 
                  "455",
                  "car_already_in",
                  ex.toString());
    }

    /**
     * NoFreeSlotException - Exception is thrown when the parking lot is full
     * @param ex
     * @return
     */
    @ExceptionHandler(value= NoFreeSlotException.class)
    public @ResponseBody ErrorResponse NoFreeSlotException(NoFreeSlotException ex){
        log.error(HttpStatus.CONFLICT + ex.getMessage());
        return new ErrorResponse(HttpStatus.CONFLICT.value(),
                  ex.getMessage(), 
                  "458",
                  "park_is_full",
                  ex.toString());
    }

    /**
     * NoLicensePlaceInException - Exception is thrown when the LicensePlate is not found in the parking lot
     * @param ex
     * @return
     */
    @ExceptionHandler(value= NoLicensePlaceInException.class)
    public @ResponseBody ErrorResponse NoLicensePlaceInException(NoLicensePlaceInException ex){
        log.error(HttpStatus.CONFLICT + ex.getMessage());
        return new ErrorResponse(HttpStatus.CONFLICT.value(),
                  ex.getMessage(), 
                  "459",
                  "park_in_not_found",
                  ex.toString());
    }

    /**
     * GenericException - Exception is thrown when the LicensePlate is not found in the parking lot
     * @param ex
     * @return
     */
    @ExceptionHandler(value= GenericException.class)
    public @ResponseBody ErrorResponse GenericException(GenericException ex){
        log.error(HttpStatus.CONFLICT + ex.getMessage());
        return new ErrorResponse(HttpStatus.CONFLICT.value(),
                  ex.getMessage(), 
                  "458",
                  "park_is_full",
                  ex.toString());
    }

    /**
     * IllegalArgumentException - Exception is thrown when the LicensePlate is not found in the parking lot
     * @param ex
     * @return
     */
    @ExceptionHandler(value= IllegalArgumentException.class)
    public @ResponseBody ErrorResponse IllegalArgumentException(IllegalArgumentException ex){
        log.error(HttpStatus.BAD_REQUEST + ex.getMessage());
        return new ErrorResponse(HttpStatus.BAD_REQUEST.value(),
                  ex.getMessage(), 
                  "420",
                  "invalid_email_password",
                  ex.toString());
    }

    /**
     * ServletException - Exception is thrown when the LicensePlate is not found in the parking lot
     * @param ex
     * @return
     */
    @ExceptionHandler(value= ServletException.class)
    public @ResponseBody ErrorResponse ServletException(ServletException ex){
        log.error(HttpStatus.FORBIDDEN + ex.getMessage());
        return new ErrorResponse(HttpStatus.FORBIDDEN.value(),
                  ex.getLocalizedMessage(), 
                  "431",
                  "invalid_token",
                  ex.toString());
    }

}