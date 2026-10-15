package com.arthur.library_management_api.Exceptions;

public class AuthorNotFoundException extends RuntimeException{

    public AuthorNotFoundException(String message){
        super(message);
    }
}
