package com.cts.course_service.repository;

import com.cts.course_service.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface CourseRepository extends JpaRepository<Course,Long> {
    @Query("select c from Course c where c.courseId =:courseId")
    Optional<Course> findCourseById(@Param("courseId") Long courseId);
}
