package com.example.schoolmanagementproject.Entities;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;


import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@Table
public class Attendance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "Date and time is required")
    @Column(nullable = false)
    private LocalDateTime dateTime;


    @NotNull(message = "Date and time is required")
    @OneToOne
    @JoinTable(name = "student_attendance", joinColumns = @JoinColumn(name = "attendance_id"),
            inverseJoinColumns = @JoinColumn(name = "student_id"))
    private Student students;


    @NotNull(message = "Attendance status is required")
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private AttendanceStatus status;


}
