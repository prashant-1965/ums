package com.cts.course_service.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private Long courseId;

    private String courseName;
    private String department;
    private Integer credits;
    private Integer durationInMonths;
}
