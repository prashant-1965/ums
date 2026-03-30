package com.cts.faculty_service.service;

import com.cts.faculty_service.dto.FacultyRegistrationDto;
import com.cts.faculty_service.entity.Faculty;
import com.cts.faculty_service.exception.FacultyException;
import com.cts.faculty_service.projection.FacultyListByCourseIdProjection;
import com.cts.faculty_service.repository.FacultyRepository;
import com.cts.faculty_service.util.DtoMapper;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@AllArgsConstructor
@Service
public class FacultyServiceImpl implements IFacultyService{

    private final FacultyRepository facultyRepository;
    @Override
    @Transactional
    public String registerFaculty(FacultyRegistrationDto facultyRegistrationDto) {
        Faculty faculty = DtoMapper.facultyDtoMapper(facultyRegistrationDto);
        facultyRepository.save(faculty);
        return "Faculty registered successfully: "+faculty.getFacultyId();
    }

    @Override
    public List<FacultyListByCourseIdProjection> findFacultyDetailsByCourseId(Long courseId) {
        List<FacultyListByCourseIdProjection> facultyListByCourseIdProjections = facultyRepository.findFacultyDetailsByCourseId(courseId);
        if(facultyListByCourseIdProjections.isEmpty()){
            throw new FacultyException("No course available for course"+courseId, HttpStatus.NOT_FOUND);
        }
        return facultyListByCourseIdProjections;
    }
}
