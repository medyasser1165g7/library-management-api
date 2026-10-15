package com.arthur.library_management_api.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.ZonedDateTime;
@RestControllerAdvice
public class GlobalExceptionHandler {

    //build error response
    public ResponseEntity<Object> buildErrorResponse(Exception exception, HttpStatus status){
        ErrorResponse response = new ErrorResponse(
                exception.getMessage(),
                status,
                ZonedDateTime.now()
        );
        return new ResponseEntity<>(response, status);
    }

    //handle book not found
    @ExceptionHandler(BookNotFoundException.class)
    public ResponseEntity<Object> handleBookNotFoundException(BookNotFoundException exception){
        return buildErrorResponse(exception, HttpStatus.NOT_FOUND);
    }
    //author not found handler
    @ExceptionHandler(AuthorNotFoundException.class)
    public ResponseEntity<Object> handleAuthorNotFound(AuthorNotFoundException exception){
        return buildErrorResponse(exception,  HttpStatus.NOT_FOUND);
    }
}
