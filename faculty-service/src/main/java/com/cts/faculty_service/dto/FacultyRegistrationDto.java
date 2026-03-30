package com.cts.faculty_service.dto;

import lombok.Getter;

@Getter
public class FacultyRegistrationDto {

    private String firstName;
    private String lastName;
    private String email;
    private String designation;
    private Double salary;
    private Long courseId;
}