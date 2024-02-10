package com.example.schoolmanagementproject.Service;


import com.example.schoolmanagementproject.Entities.Student;
import com.example.schoolmanagementproject.Repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    @Autowired
    StudentRepository studentRepository;

    public Student CreateStudent(Student student) {

        Student student1 = new Student();
        student1.setName(student.getName());
        student1.setId(student.getId());
        studentRepository.save(student1);
        return student;

    }

    public List<Student> getAllStudents() {
        List<Student> students = studentRepository.findAll();
        return students;
    }

    public Optional<Student> getStudentById(Long id) {
        Optional<Student> student = studentRepository.findById(id);
        return student;


    }

    public void updateStudent(Long id, Student updatedStudent) {

        if (studentRepository.existsById(id)) {
            Student student = new Student();
            student.setName(updatedStudent.getName());
            student.setId(updatedStudent.getId());
            studentRepository.save(student);
        } else {
            throw new IllegalArgumentException("Student with ID " + id + " not found");
        }
    }
    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
    }
}



