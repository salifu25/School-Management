package com.example.schoolmanagementproject.Controller;

import com.example.schoolmanagementproject.DTO.AttendanceRequestDto;
import com.example.schoolmanagementproject.Entities.Attendance;
import com.example.schoolmanagementproject.Service.AttendanceService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/attendances")
public class AttendanceController {

    @Autowired
    private AttendanceService attendanceService;

    @PostMapping("/createAttendance")
    public ResponseEntity<?> createAttendance(@Valid @RequestBody AttendanceRequestDto attendance) {
        Attendance createdAttendance = attendanceService.createAttendance(attendance);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdAttendance);
    }

    @GetMapping("/listAttendance")
    public ResponseEntity<List<Attendance>> getAllAttendances() {
        List<Attendance> attendances = attendanceService.getAllAttendances();
        return ResponseEntity.ok(attendances);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Attendance> getAttendanceById(@PathVariable Long id) {
        Optional<Attendance> attendanceOptional = attendanceService.getAttendanceById(id);
        return attendanceOptional.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("updateAttendance/{id}")
    public ResponseEntity<?> updateAttendance(@PathVariable Long id, @Valid @RequestBody Attendance updatedAttendance) {
        attendanceService.updateAttendance(id, updatedAttendance);
        return ResponseEntity.ok(updatedAttendance);
    }

    @DeleteMapping("deleteAttendance/{id}")
    public ResponseEntity<?> deleteAttendance(@PathVariable Long id) {
        attendanceService.deleteAttendance(id);
        return ResponseEntity.ok("Deleted successfully");
    }
}
