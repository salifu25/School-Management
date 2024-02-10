package com.example.schoolmanagementproject.Controller;

import com.example.schoolmanagementproject.DTO.StudentClassRequestDto;
import com.example.schoolmanagementproject.Entities.StudentClass;
import com.example.schoolmanagementproject.Service.StudentClassService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/student-classes")
@AllArgsConstructor
public class StudentClassController {


    StudentClassService studentClassService;


    @PostMapping("/createStudentClass")
    public ResponseEntity<?> createStudentClass(@Valid @RequestBody StudentClassRequestDto studentClass) {
        StudentClass createdStudentClass = studentClassService.createStudentClass(studentClass);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdStudentClass);
    }

    @GetMapping
    public ResponseEntity<List<StudentClass>> getAllStudentClasses() {
        List<StudentClass> studentClasses = studentClassService.getAllStudentClasses();
        return ResponseEntity.ok(studentClasses);
    }

    @GetMapping("/{id}")
    public ResponseEntity<StudentClass> getStudentClassById(@PathVariable Long id) {
        Optional<StudentClass> studentClassOptional = studentClassService.getStudentClassById(id);
        return studentClassOptional.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("updateStudentClass/{id}")
    public ResponseEntity<?> updateStudentClass(@PathVariable Long id, @Valid @RequestBody StudentClass updatedStudentClass) {
        studentClassService.updateStudentClass(id, updatedStudentClass);
        return ResponseEntity.ok(updatedStudentClass);
    }

    @DeleteMapping("deleteStudentClass/{id}")
    public ResponseEntity<?> deleteStudentClass(@PathVariable Long id) {
        studentClassService.deleteStudentClass(id);
        return ResponseEntity.ok("Deleted successfully");
    }
}
