package com.example.schoolmanagementproject.Entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

//
//
import java.util.List;
@Entity
@Data
@Table

public class StudentClass {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @ManyToOne
    @JoinColumn(name = "campus_id")
    private Campus campus;

    @OneToMany(mappedBy = "studentClass", cascade = CascadeType.ALL)
    private List<Student> students;
}
