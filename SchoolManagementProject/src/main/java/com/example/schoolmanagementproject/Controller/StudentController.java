package com.example.schoolmanagementproject.Controller;

import com.example.schoolmanagementproject.DTO.StudentRequestDto;
import com.example.schoolmanagementproject.Entities.Student;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.schoolmanagementproject.Service.StudentService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")


public class StudentController {
    @Autowired
    StudentService studentService;

    @GetMapping
    public ResponseEntity<List<Student>> getAllStudents() {
        List<Student> students = studentService.getAllStudents();
        return new ResponseEntity<>(students, HttpStatus.OK);
    }
    @GetMapping("/students/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable Long id) {
        return studentService.getStudentById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
    @PostMapping("createStudent")
    public ResponseEntity<?> createStudent(@Valid @RequestBody StudentRequestDto student) {
        Student createdStudent = studentService.createStudent(student);
        return new ResponseEntity<>(createdStudent, HttpStatus.CREATED);
    }
    @PutMapping("updateStudent/{id}")
    public ResponseEntity<?> updateStudent(@PathVariable Long id, @Valid @RequestBody StudentRequestDto student) {
        studentService.updateStudent(id, student);
        return ResponseEntity.ok(student);
    }
    @DeleteMapping("deleteStudent/{id}")
    public ResponseEntity<?> deleteStudent(@PathVariable Long id) {
        studentService.deleteStudent(id);
        return ResponseEntity.ok("Deleted successfully ");
    }
}





