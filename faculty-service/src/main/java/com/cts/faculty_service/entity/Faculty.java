package com.cts.faculty_service.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Faculty {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private Long facultyId;

    private String firstName;
    private String lastName;

    @Column(unique = true)
    private String email;

    private String designation;
    private Double salary;
    private Long courseId;
}
