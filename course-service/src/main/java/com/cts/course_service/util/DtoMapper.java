package com.cts.course_service.util;

import com.cts.course_service.dto.request.CourseRegistrationDto;
import com.cts.course_service.entity.Course;

public class DtoMapper {
    public static Course courseRegistration(CourseRegistrationDto courseRegistrationDto){
        Course course = new Course();
        course.setCourseName(courseRegistrationDto.getCourseName());
        course.setDepartment(courseRegistrationDto.getDepartment());
        course.setCredits(courseRegistrationDto.getCredits());
        course.setDurationInMonths(courseRegistrationDto.getDurationInMonths());
        Long courseId = UIDGeneratorUtils.uidGenerator();
        course.setCourseId(courseId);
        return course;
    }
}
