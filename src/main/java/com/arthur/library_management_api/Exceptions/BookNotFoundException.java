package com.arthur.library_management_api.Exceptions;

public class BookNotFoundException extends RuntimeException {

    public BookNotFoundException(String message){
        super(message);
    }
    public BookNotFoundException(String message, Throwable cause){
        super(message, cause);
    }
}
