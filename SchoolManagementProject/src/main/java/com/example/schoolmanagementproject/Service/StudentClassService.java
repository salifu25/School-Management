package com.example.schoolmanagementproject.Service;

import com.example.schoolmanagementproject.DTO.StudentClassRequestDto;
import com.example.schoolmanagementproject.Entities.Campus;
import com.example.schoolmanagementproject.Entities.StudentClass;
import com.example.schoolmanagementproject.Repository.StudentClassRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class StudentClassService {
    @Autowired
    private StudentClassRepository studentClassRepository;

    @Lazy
    @Autowired
    private CampusService campusService;

    public StudentClass createStudentClass( StudentClassRequestDto studentClass) {
        Campus campus = campusService.getCampusById(studentClass.getCampus_id()).get();
        StudentClass newStudentClass = new StudentClass();
        newStudentClass.setName(studentClass.getName());
        newStudentClass.setCampus(campus);
        studentClassRepository.save(newStudentClass);
        return newStudentClass;
    }

    public List<StudentClass> getAllStudentClasses() {
        return studentClassRepository.findAll();
    }

    public Optional<StudentClass> getStudentClassById(Long id) {
        return studentClassRepository.findById(id);
    }

    public List<?> getAllClassesByCampusId(long id){
        return studentClassRepository.findStudentClassByCampus_Id(id);
    }

    public void updateStudentClass(Long id, StudentClass updatedStudentClass) {
        if (studentClassRepository.existsById(id)) {
            StudentClass existingStudentClass = studentClassRepository.findById(id).orElse(null);
            if (existingStudentClass != null) {
                existingStudentClass.setName(updatedStudentClass.getName());
                existingStudentClass.setId(updatedStudentClass.getId());
                studentClassRepository.save(existingStudentClass);
            }
        } else {
            throw new IllegalArgumentException("StudentClass with ID " + id + " not found");
        }
    }

    public void deleteStudentClass(Long id) {
        studentClassRepository.deleteById(id);
    }
}

