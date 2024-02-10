package com.example.schoolmanagementproject.DTO;

import com.example.schoolmanagementproject.Entities.Campus;
import com.example.schoolmanagementproject.Entities.StudentClass;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class CampusDto {

    private Campus campus;
    private List<?> studentClasses;


}
