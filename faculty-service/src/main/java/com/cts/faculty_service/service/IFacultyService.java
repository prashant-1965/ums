package com.cts.faculty_service.service;

import com.cts.faculty_service.dto.FacultyRegistrationDto;
import com.cts.faculty_service.projection.FacultyListByCourseIdProjection;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface IFacultyService {
    String registerFaculty(FacultyRegistrationDto facultyRegistrationDto);
    List<FacultyListByCourseIdProjection> findFacultyDetailsByCourseId(Long courseId);
}
