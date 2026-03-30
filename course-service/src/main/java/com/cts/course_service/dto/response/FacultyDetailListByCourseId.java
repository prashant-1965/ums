package com.cts.course_service.dto.response;

import lombok.Data;

@Data
public class FacultyDetailListByCourseId {
    private Long facultyId;
    private String firstName;
    private String lastName;
    private String email;
    private String designation;
    private Double salary;
}
