package com.example.schoolmanagementproject.DTO;

import com.example.schoolmanagementproject.Entities.StudentClass;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class StudentRequestDto {

    @NotNull(message = "Name is required")
    @Size(min = 2, max = 255, message = "Name must be between 2 and 255 characters")
    private String name;

    @NotNull(message = "class id is required")
    private long class_id;

    @NotNull(message = "parent id is required")
    private long parent_id;
}
