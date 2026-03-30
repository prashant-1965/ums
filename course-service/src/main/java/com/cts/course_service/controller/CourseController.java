package com.cts.course_service.controller;

import com.cts.course_service.dto.request.CourseRegistrationDto;
import com.cts.course_service.dto.response.FacultyDetailListByCourseId;
import com.cts.course_service.service.ICourseService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/course")
public class CourseController {
    private final ICourseService courseService;

    @PostMapping("/register")
    public ResponseEntity<String> registerCourse(@RequestBody CourseRegistrationDto courseRegistrationDto){
        return ResponseEntity.status(200).body(courseService.registerCourse(courseRegistrationDto));
    }

    @GetMapping("/findFacultyListByCourseId/{courseId}")
    public ResponseEntity<List<FacultyDetailListByCourseId>> findFacultyDetailsByCourseId(@PathVariable Long courseId){
        return ResponseEntity.status(200).body(courseService.findFacultyDetailsByCourseId(courseId));
    }
}
