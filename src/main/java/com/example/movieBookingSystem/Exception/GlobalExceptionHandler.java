package com.example.movieBookingSystem.Exception;

import com.example.movieBookingSystem.entities.ErrorObj;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Date;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(MovieAlreadyPresentWithSameNameAndLanguage.class)
public ResponseEntity<ErrorObj>handleMovieAlreadyPresentException(MovieAlreadyPresentWithSameNameAndLanguage ex)
    {
        ErrorObj errorObj = new ErrorObj();
        errorObj.setMessage(ex.getMessage());
        errorObj.setStatusCode(HttpStatus.CONFLICT.value());
        errorObj.setTimestamp(new Date());
        return new ResponseEntity<>(errorObj, HttpStatus.CONFLICT);
    }
    @ExceptionHandler(MovieDoesNotExists.class)
    public ResponseEntity<ErrorObj>handleMovieDoesNotExistExcetion(MovieDoesNotExists ex)
    {
        ErrorObj errorObj = new ErrorObj();
        errorObj.setMessage(ex.getMessage());
        errorObj.setStatusCode(HttpStatus.NOT_FOUND.value());
        errorObj.setTimestamp(new Date());
        return new ResponseEntity<>(errorObj, HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(RequestedSeatAreNotAvailable.class)
    public ResponseEntity<ErrorObj>handleRequestedSeatAreNotAvailableException(RequestedSeatAreNotAvailable ex)
    {
        ErrorObj errorObj = new ErrorObj();
        errorObj.setMessage(ex.getMessage());
        errorObj.setStatusCode(HttpStatus.CONFLICT.value());
        errorObj.setTimestamp(new Date());
        return new ResponseEntity<>(errorObj, HttpStatus.CONFLICT);
    }
    @ExceptionHandler(ShowDoesNotExists.class)
    public ResponseEntity<ErrorObj>handleShowDoesNotExistsException(ShowDoesNotExists ex)
    {
        ErrorObj errorObj = new ErrorObj();
        errorObj.setMessage(ex.getMessage());
        errorObj.setStatusCode(HttpStatus.NOT_FOUND.value());
        errorObj.setTimestamp(new Date());
        return new ResponseEntity<>(errorObj, HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(TheaterDoesNotExists.class)
    public ResponseEntity<ErrorObj>handleTheaterDoesNotExistsException(TheaterDoesNotExists ex)
    {
        ErrorObj errorObj = new ErrorObj();
        errorObj.setMessage(ex.getMessage());
        errorObj.setStatusCode(HttpStatus.NOT_FOUND.value());
        errorObj.setTimestamp(new Date());
        return new ResponseEntity<>(errorObj, HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(TheaterIsNotPresentOnThisAddress.class)
    public ResponseEntity<ErrorObj>handleTheaterIsNotPresentOnThisAddressException(TheaterIsNotPresentOnThisAddress ex)
    {
        ErrorObj errorObj = new ErrorObj();
        errorObj.setMessage(ex.getMessage());
        errorObj.setStatusCode(HttpStatus.NOT_FOUND.value());
        errorObj.setTimestamp(new Date());
        return new ResponseEntity<>(errorObj, HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(TheaterIsPresentOnThatAddress.class)
    public ResponseEntity<ErrorObj>handleTheaterIsNotPresentOnThatAddressException(TheaterIsPresentOnThatAddress ex)
    {
        ErrorObj errorObj = new ErrorObj();
        errorObj.setMessage(ex.getMessage());
        errorObj.setStatusCode(HttpStatus.NOT_FOUND.value());
        errorObj.setTimestamp(new Date());
        return new ResponseEntity<>(errorObj, HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(UserAlreadyExistsWithEmail.class)
    public ResponseEntity<ErrorObj>handleUserAlreadyExistsWithEmailException(UserAlreadyExistsWithEmail ex)
    {
        ErrorObj errorObj = new ErrorObj();
        errorObj.setMessage(ex.getMessage());
        errorObj.setStatusCode(HttpStatus.CONFLICT.value());
        errorObj.setTimestamp(new Date());
        return new ResponseEntity<>(errorObj, HttpStatus.CONFLICT);
    }
    @ExceptionHandler(UserDoesNotExists.class)
    public ResponseEntity<ErrorObj>handleUserDoesNotExistsException(UserDoesNotExists ex)
    {
        ErrorObj errorObj = new ErrorObj();
        errorObj.setMessage(ex.getMessage());
        errorObj.setStatusCode(HttpStatus.NOT_FOUND.value());
        errorObj.setTimestamp(new Date());
        return new ResponseEntity<>(errorObj, HttpStatus.NOT_FOUND);

    }









}
