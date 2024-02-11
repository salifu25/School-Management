package com.example.schoolmanagementproject.Service;


import com.example.schoolmanagementproject.DTO.StudentRequestDto;
import com.example.schoolmanagementproject.Entities.Parent;
import com.example.schoolmanagementproject.Entities.Student;
import com.example.schoolmanagementproject.Entities.StudentClass;
import com.example.schoolmanagementproject.Repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    @Autowired
    StudentRepository studentRepository;

    @Autowired
    StudentClassService studentClassService;

    @Autowired
    ParentService parentService;


    public Student createStudent(StudentRequestDto student) {
        // Retrieve StudentClass and Parent entities
        StudentClass studentClass = studentClassService.getStudentClassById(student.getClass_id())
                .orElseThrow(() -> new IllegalArgumentException("StudentClass with ID " + student.getClass_id() + " not found"));

        Parent parent = parentService.getParentById(student.getParent_id())
                .orElseThrow(() -> new IllegalArgumentException("Parent with ID " + student.getParent_id() + " not found"));

        // Create and save the Student entity
        Student newStudent = new Student();
        newStudent.setName(student.getName());
        newStudent.setStudentClass(studentClass);
        newStudent.setParent(parent);
        studentRepository.save(newStudent);
        return newStudent;
    }

    public List<Student> getAllStudents() {
        List<Student> students = studentRepository.findAll();
        return students;
    }

    public Optional<Student> getStudentById(Long id) {
        Optional<Student> student = studentRepository.findById(id);
        return student;


    }

    public void updateStudent(Long id, StudentRequestDto updatedStudent) {
        Optional<Student> existingStudentOptional = studentRepository.findById(id);

        if (existingStudentOptional.isPresent()) {
            Long classId = updatedStudent.getClass_id();

            if (classId != null) {
                StudentClass studentClass = studentClassService.getStudentClassById(classId)
                        .orElseThrow(() -> new IllegalArgumentException("StudentClass with ID " + classId + " not found"));

                Student existingStudent = existingStudentOptional.get();
                existingStudent.setName(updatedStudent.getName());
                existingStudent.setStudentClass(studentClass);
                studentRepository.save(existingStudent);
            } else {
                throw new IllegalArgumentException("Class ID cannot be null");
            }
        } else {
            throw new IllegalArgumentException("Student with ID " + id + " not found");
        }
    }

    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
    }
}



