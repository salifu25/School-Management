package com.example.schoolmanagementproject.Service;

import com.example.schoolmanagementproject.Entities.Parent;
import com.example.schoolmanagementproject.Repository.ParentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class ParentService {


    @Autowired
    private ParentRepository parentRepository;

    public Parent createParent( Parent parent) {
        Parent newParent = new Parent();
        newParent.setName(parent.getName());
        newParent.setContactInformation(parent.getContactInformation());
        newParent.setId(parent.getId());
        parentRepository.save(newParent);
        return newParent;
    }

    public List<Parent> getAllParents() {
        return parentRepository.findAll();
    }

    public Optional<Parent> getParentById(Long id) {
        return parentRepository.findById(id);
    }

    public void updateParent(Long id, Parent updatedParent) {
        if (parentRepository.existsById(id)) {
            Parent existingParent = parentRepository.findById(id).orElse(null);
            if (existingParent != null) {
                existingParent.setName(updatedParent.getName());
                existingParent.setContactInformation(updatedParent.getContactInformation());
                existingParent.setId(updatedParent.getId());
                parentRepository.save(existingParent);
            }
        } else {
            throw new IllegalArgumentException("Parent with ID " + id + " not found");
        }
    }

    public void deleteParent(Long id) {
        parentRepository.deleteById(id);
    }
}
