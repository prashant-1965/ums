package com.cts.faculty_service.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;
@Getter
public class FacultyException extends RuntimeException{
    private final HttpStatus httpStatus;
    public FacultyException(String message, HttpStatus httpStatus){
        super(message);
        this.httpStatus = httpStatus;
    }
}
