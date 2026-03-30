package com.cts.course_service.dto.request;

import lombok.Getter;

@Getter
public class CourseRegistrationDto {
    private String courseName;
    private String department;
    private Integer credits;
    private Integer durationInMonths;
}
