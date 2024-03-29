package com.example.schoolmanagementproject.Repository;

import com.example.schoolmanagementproject.Entities.StudentClass;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentClassRepository extends JpaRepository<StudentClass, Long> {

    List<StudentClass> findStudentClassByCampus_Id(long camp_id);
}
