package com.example.schoolmanagementproject.Repository;

import com.example.schoolmanagementproject.Entities.Campus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CampusRepository extends JpaRepository<Campus, Long> {
}
