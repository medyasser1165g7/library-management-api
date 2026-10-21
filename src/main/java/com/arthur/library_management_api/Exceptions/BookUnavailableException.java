package com.arthur.library_management_api.Exceptions;

import com.arthur.library_management_api.Entities.Book;

public class BookUnavailableException extends RuntimeException{
    public BookUnavailableException(String message){
        super(message);
    }
}
