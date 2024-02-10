package com.example.schoolmanagementproject.Controller;

import com.example.schoolmanagementproject.Entities.Parent;
import com.example.schoolmanagementproject.Service.ParentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/parents")
public class ParentController {

    @Autowired
    private ParentService parentService;

    @PostMapping
    public ResponseEntity<?> createParent(@Valid @RequestBody Parent parent) {
        Parent createdParent = parentService.createParent(parent);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdParent);
    }

    @GetMapping
    public ResponseEntity<List<Parent>> getAllParents() {
        List<Parent> parents = parentService.getAllParents();
        return ResponseEntity.ok(parents);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Parent> getParentById(@PathVariable Long id) {
        Optional<Parent> parentOptional = parentService.getParentById(id);
        return parentOptional.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateParent(@PathVariable Long id,@Valid @RequestBody Parent updatedParent) {
        parentService.updateParent(id, updatedParent);
        return ResponseEntity.ok(updatedParent);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteParent(@PathVariable Long id) {
        parentService.deleteParent(id);
        return ResponseEntity.ok("Deleted successfully");
    }
}

