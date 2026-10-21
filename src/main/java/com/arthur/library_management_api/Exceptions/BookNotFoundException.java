package com.arthur.library_management_api.Exceptions;

import lombok.NoArgsConstructor;

public class BookNotFoundException extends RuntimeException {

    public BookNotFoundException(String message){
        super(message);
    }

}
