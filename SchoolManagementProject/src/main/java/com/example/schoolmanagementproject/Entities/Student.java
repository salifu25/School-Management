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
public class Student {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;

  @NotNull(message = "Name is required")
  @Size(min = 2, max = 255, message = "Name must be between 2 and 255 characters")
  @Column(nullable = false)
    private String name;

    @ManyToOne
    @JoinColumn(name = "class_id", nullable = false)
    private StudentClass studentClass;

  @ManyToOne
  @JoinColumn(name = "parent_id", nullable = false)
  private Parent parent;

  @OneToMany(mappedBy = "student", cascade = CascadeType.ALL)
  private List<Attendance> attendances;


 // @ManyToOne
  //@JoinColumn(name = "parent_id")
  //private Parent parent;



}
