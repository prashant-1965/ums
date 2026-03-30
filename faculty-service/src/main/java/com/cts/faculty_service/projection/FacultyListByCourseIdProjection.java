package com.cts.faculty_service.projection;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class FacultyListByCourseIdProjection {
    private Long facultyId;
    private String firstName;
    private String lastName;
    private String email;
    private String designation;
    private Double salary;
}
