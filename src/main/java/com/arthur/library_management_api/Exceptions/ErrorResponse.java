package com.arthur.library_management_api.Exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

import java.time.ZonedDateTime;
@Getter
@AllArgsConstructor
public class ErrorResponse {
    private String message;
    private HttpStatus httpStatus;
    private ZonedDateTime timeStamp;
}
