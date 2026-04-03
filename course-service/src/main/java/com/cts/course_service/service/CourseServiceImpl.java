package com.cts.course_service.service;

import com.cts.course_service.dto.request.CourseRegistrationDto;
import com.cts.course_service.dto.response.FacultyDetailListByCourseId;
import com.cts.course_service.entity.Course;
import com.cts.course_service.exception.CourseException;
import com.cts.course_service.feign.FacultyFeign;
import com.cts.course_service.repository.CourseRepository;
import com.cts.course_service.util.DtoMapper;
import feign.FeignException;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class CourseServiceImpl implements ICourseService{
    private final CourseRepository courseRepository;
    private final FacultyFeign facultyFeign;

    @Override
    @Transactional
    public String registerCourse(CourseRegistrationDto courseRegistrationDto) {
        Course course = DtoMapper.courseRegistration(courseRegistrationDto);
        courseRepository.save(course);
        return "Course registered successfully: "+course.getCourseId();
    }

    @Override
    @Retry(name = "facultyRetry")
    @CircuitBreaker(name = "courseService",fallbackMethod = "handelCourseServiceFallback")
    public List<FacultyDetailListByCourseId> findFacultyDetailsByCourseId(Long courseId) throws CourseException {
        Optional<Course> course = courseRepository.findCourseById(courseId);
        if(course.isEmpty()){
            throw new CourseException(LocalDate.now(),"Course is not available with id: "+courseId, HttpStatus.NOT_FOUND);
        }
        return facultyFeign.findFacultyDetailsByCourseId(courseId);
    }

    public List<FacultyDetailListByCourseId> handelCourseServiceFallback(Long courseId, Exception ex) {
        if (ex instanceof feign.FeignException.NotFound) {
            return Collections.emptyList();
        }
        if (ex instanceof FeignException.ServiceUnavailable) {
            throw new CourseException(LocalDate.now(),"Course service is down",HttpStatus.SERVICE_UNAVAILABLE);
        }
        throw new CourseException(LocalDate.now(),"Unknown error occurred",HttpStatus.SERVICE_UNAVAILABLE);
    }

}
