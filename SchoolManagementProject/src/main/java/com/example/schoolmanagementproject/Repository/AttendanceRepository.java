package com.example.schoolmanagementproject.Repository;

import com.example.schoolmanagementproject.Entities.Attendance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AttendanceRepository extends JpaRepository<Attendance, Long>{
}
