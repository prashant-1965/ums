package com.cts.faculty_service.globalexception;

import com.cts.faculty_service.exception.FacultyException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class globalException {

    @ExceptionHandler(FacultyException.class)
    public ResponseEntity<String> facultyExceptionHandel(FacultyException f){
        return ResponseEntity.status(f.getHttpStatus()).body(f.getMessage());
    }
}
