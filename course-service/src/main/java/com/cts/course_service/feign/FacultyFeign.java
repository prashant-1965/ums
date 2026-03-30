package com.cts.course_service.feign;

import com.cts.course_service.dto.response.FacultyDetailListByCourseId;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "faculty-service")
public interface FacultyFeign {
    @GetMapping("/faculty/findFacultyByCourseId/{courseId}")
    List<FacultyDetailListByCourseId> findFacultyDetailsByCourseId(@PathVariable Long courseId);
}