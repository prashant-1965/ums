package com.cts.faculty_service.util;

import com.cts.faculty_service.dto.FacultyRegistrationDto;
import com.cts.faculty_service.entity.Faculty;

public class DtoMapper {
    public static Faculty facultyDtoMapper(FacultyRegistrationDto facultyRegistrationDto){
        Faculty faculty = new Faculty();
        faculty.setFirstName(facultyRegistrationDto.getFirstName());
        faculty.setLastName(facultyRegistrationDto.getLastName());
        faculty.setEmail(facultyRegistrationDto.getEmail());
        faculty.setDesignation(facultyRegistrationDto.getDesignation());
        faculty.setCourseId(facultyRegistrationDto.getCourseId());
        Long facultyId = UIDGeneratorUtils.uidGenerator();
        faculty.setFacultyId(facultyId);
        return faculty;
    }
}
