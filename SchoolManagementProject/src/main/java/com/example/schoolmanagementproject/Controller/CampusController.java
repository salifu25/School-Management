package com.example.schoolmanagementproject.Controller;

import com.example.schoolmanagementproject.DTO.CampusDto;
import com.example.schoolmanagementproject.Entities.Campus;
import com.example.schoolmanagementproject.Service.CampusService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/campuses")
public class CampusController {

    @Autowired
    private CampusService campusService;

    @PostMapping("/createCampus")
    public ResponseEntity<?> createCampus(@Valid @RequestBody  Campus campus) {
        Campus createdCampus = campusService.createCampus(campus);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdCampus);
    }

    @GetMapping
    public ResponseEntity<List<Campus>> getAllCampuses() {

        List<Campus> campuses = campusService.getAllCampuses();
        return ResponseEntity.ok(campuses);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getCampusById(@PathVariable Long id) {
        CampusDto campusOptional = campusService.getCampusWithClassesById(id);
       return ResponseEntity.ok(campusOptional);
    }

    @PutMapping("updateCampus/{id}")
    public ResponseEntity<?> updateCampus ( @PathVariable Long id,@Valid @RequestBody Campus updatedCampus) {
       Campus campus = campusService.updateCampus(id, updatedCampus);
        return ResponseEntity.ok(campus);
    }

    @DeleteMapping("deleteCampus/{id}")
    public ResponseEntity<?> deleteCampus(@PathVariable Long id) {
        campusService.deleteCampus(id);
        return ResponseEntity.ok("deleted");
    }
}
