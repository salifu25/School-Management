package com.example.schoolmanagementproject.Service;

import com.example.schoolmanagementproject.DTO.AttendanceRequestDto;
import com.example.schoolmanagementproject.Entities.Attendance;
import com.example.schoolmanagementproject.Entities.Student;
import com.example.schoolmanagementproject.Repository.AttendanceRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class AttendanceService {
    @Autowired
    private AttendanceRepository attendanceRepository;

    @Autowired
    private StudentService studentService;



    public Attendance createAttendance(AttendanceRequestDto attendance) {

        try {
            Optional<Student> student = studentService.getStudentById(attendance.getStudent_id());
            if (student.isEmpty()){
                return  null;
            }
            Attendance newAttendance = new Attendance();
            newAttendance.setDateTime(attendance.getDateTime());
            newAttendance.setStatus(attendance.getStatus());
            newAttendance.setStudent(student.get());
            attendanceRepository.save(newAttendance);
            log.info("attendance created successfully");
            return newAttendance;
        }catch (Exception e){
            log.error(e.getMessage());
            return  null;
        }

    }

    public List<Attendance> getAllAttendances() {

        return attendanceRepository.findAll();
    }

    public Optional<Attendance> getAttendanceById(Long id) {

        return attendanceRepository.findById(id);
    }

    public void updateAttendance(Long id, Attendance updatedAttendance) {
        Optional<Attendance> existingAttendanceOptional = attendanceRepository.findById(id);

        if (existingAttendanceOptional.isPresent()) {
            Attendance existingAttendance = existingAttendanceOptional.get();
            existingAttendance.setDateTime(updatedAttendance.getDateTime());
            existingAttendance.setStatus(updatedAttendance.getStatus());
            attendanceRepository.save(existingAttendance);
        } else {
            throw new IllegalArgumentException("Attendance with ID " + id + " not found");
        }
    }

    public void deleteAttendance(Long id) {

        attendanceRepository.deleteById(id);
    }
}
