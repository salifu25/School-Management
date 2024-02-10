package com.example.schoolmanagementproject.Entities;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

//
//
import java.util.List;

@Entity
@Table
@Data
public class Campus {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "Name is required")
    @Column(nullable = false)
    private String name;

    @NotNull(message = "Address is required")
    @Column(nullable = false)
    private String address;


    @NotNull(message = "Contact information is required")
    @Pattern(regexp = "\\d{10}", message = "Contact information must be a 10-digit number")
    @Column(nullable = false)
    private String contactInformation;


    /*@OneToMany
    private List<StudentClass> classes;*/
}
