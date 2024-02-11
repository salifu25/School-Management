package com.example.schoolmanagementproject.DTO;

import com.example.schoolmanagementproject.Entities.AttendanceStatus;
import com.example.schoolmanagementproject.Entities.Student;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class AttendanceRequestDto {

    @NotNull(message = "Date and time is required")
    private LocalDateTime dateTime;


    @NotNull(message = "student id is required")
    private long student_id;


    @NotNull(message = "Attendance status is required")
    private AttendanceStatus status;
}
