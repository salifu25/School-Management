package com.example.schoolmanagementproject.DTO;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class StudentClassRequestDto {

    @NotNull(message = "Name is required")
    @Size(min = 2, max = 20, message = "Name must be between 2 and 20 characters")
    private String name;

    private long Campus_id;
}
