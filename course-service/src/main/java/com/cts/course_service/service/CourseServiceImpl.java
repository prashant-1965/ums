package com.cts.course_service.service;

import com.cts.course_service.dto.request.CourseRegistrationDto;
import com.cts.course_service.dto.response.FacultyDetailListByCourseId;
import com.cts.course_service.entity.Course;
import com.cts.course_service.exception.CourseException;
import com.cts.course_service.feign.FacultyFeign;
import com.cts.course_service.repository.CourseRepository;
import com.cts.course_service.util.DtoMapper;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
    public List<FacultyDetailListByCourseId> findFacultyDetailsByCourseId(Long courseId) throws CourseException {
        Optional<Course> course = courseRepository.findCourseById(courseId);
        if(course.isEmpty()){
            throw new CourseException("Course is not available with id: "+courseId, HttpStatus.NOT_FOUND);
        }
        return facultyFeign.findFacultyDetailsByCourseId(courseId);
    }

}
