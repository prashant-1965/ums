package com.cts.faculty_service.repository;

import com.cts.faculty_service.entity.Faculty;
import com.cts.faculty_service.projection.FacultyListByCourseIdProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FacultyRepository extends JpaRepository<Faculty,Long> {

    @Query("select new com.cts.faculty_service.projection.FacultyListByCourseIdProjection(f.facultyId,f.firstName,f.lastName,f.email,f.designation,f.salary)"+" from Faculty f where f.courseId = :courseId ")
    List<FacultyListByCourseIdProjection> findFacultyDetailsByCourseId(@Param("courseId") Long courseId);

}
