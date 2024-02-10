package com.example.schoolmanagementproject.Entities;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

//
//
import java.util.List;
import java.util.Set;

@Entity
@Table
@Data
public class Parent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    @NotNull(message = "Name is required")
    private String name;


    @NotNull(message = "Contact information is required")
    @Pattern(regexp = "\\d{10}", message = "Contact information must be a 10-digit number")
    @Column(nullable = false)
    private String contactInformation;

    @OneToMany
    @JoinTable(name = "parent_student", joinColumns = @JoinColumn(name = "parent_id"),
    inverseJoinColumns = @JoinColumn(name = "student_id"))
    private List<Student> students;
}
