package com.cts.course_service.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

import java.time.LocalDate;

@Getter
public class CourseException extends RuntimeException {
    private final HttpStatus httpStatus;
    private final LocalDate localDate;
    public CourseException(LocalDate localDate, String message, HttpStatus httpStatus) {
        super(message);
        this.localDate = localDate;
        this.httpStatus = httpStatus;
    }
}
