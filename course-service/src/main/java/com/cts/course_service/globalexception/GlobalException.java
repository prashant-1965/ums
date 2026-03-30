package com.cts.course_service.globalexception;

import com.cts.course_service.exception.CourseException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalException {

    @ExceptionHandler(CourseException.class)
    public ResponseEntity<String> courseExceptionHandel(CourseException c){
        return ResponseEntity.status(c.getHttpStatus()).body(c.getMessage());
    }
}
