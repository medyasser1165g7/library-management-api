package com.arthur.library_management_api.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
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
    //handle member not foundQ
    @ExceptionHandler(MemberNotFoundException.class)
    public ResponseEntity<Object> handleMemberNotFoundExceptin(MemberNotFoundException exception){

        return buildErrorResponse(exception, HttpStatus.NOT_FOUND);
    }
    //handle borrowing not found
    @ExceptionHandler(BorrowingNotFoundException.class)
    public ResponseEntity<Object> handleBorrowingNotFoundException(BorrowingNotFoundException exception){
        return buildErrorResponse(exception, HttpStatus.NOT_FOUND);
    }
    //handle book unavailable exception
    @ExceptionHandler(BookUnavailableException.class)
    public ResponseEntity<Object> handleBookUnavailableException(BookUnavailableException exception){
        return buildErrorResponse(exception, HttpStatus.CONFLICT);
    }

    // handle validation exception
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Object> handleNotValidException(MethodArgumentNotValidException exception){
        return buildErrorResponse(exception, HttpStatus.BAD_REQUEST);
    }
}
