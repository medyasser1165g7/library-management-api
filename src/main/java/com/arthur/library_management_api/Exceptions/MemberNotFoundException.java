package com.arthur.library_management_api.Exceptions;

import com.arthur.library_management_api.Entities.Member;
import lombok.NoArgsConstructor;

public class MemberNotFoundException extends RuntimeException{

    public MemberNotFoundException(String message){
        super(message);
    }
}
