package com.cts.faculty_service.controller;

import com.cts.faculty_service.dto.FacultyRegistrationDto;
import com.cts.faculty_service.projection.FacultyListByCourseIdProjection;
import com.cts.faculty_service.service.IFacultyService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/faculty")
public class FacultyController {
    private final IFacultyService facultyService;

    @PostMapping("/register")
    public ResponseEntity<String> registerCourse(@RequestBody FacultyRegistrationDto facultyRegistrationDto){
        return ResponseEntity.status(200).body(facultyService.registerFaculty(facultyRegistrationDto));
    }

    @GetMapping("/findFacultyByCourseId/{courseId}")
    public ResponseEntity<List<FacultyListByCourseIdProjection>> findFacultyDetailsByCourseId(@PathVariable Long courseId){
        return ResponseEntity.status(200).body(facultyService.findFacultyDetailsByCourseId(courseId));
    }
}
