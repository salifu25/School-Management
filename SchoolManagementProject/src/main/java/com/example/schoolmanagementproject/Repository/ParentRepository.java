package com.example.schoolmanagementproject.Repository;

import com.example.schoolmanagementproject.Entities.Parent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParentRepository extends JpaRepository<Parent, Long> {
}
