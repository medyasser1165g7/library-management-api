package com.arthur.library_management_api.Exceptions;

public class BorrowingNotFoundException extends RuntimeException{
    public BorrowingNotFoundException(String message){
        super(message);
    }
}
