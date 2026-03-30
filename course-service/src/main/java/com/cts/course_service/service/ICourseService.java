package com.cts.course_service.service;

import com.cts.course_service.dto.request.CourseRegistrationDto;
import com.cts.course_service.dto.response.FacultyDetailListByCourseId;

import java.util.List;

public interface ICourseService {
    String registerCourse(CourseRegistrationDto courseRegistrationDto);
    List<FacultyDetailListByCourseId> findFacultyDetailsByCourseId(Long courseId);


}
