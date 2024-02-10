package com.example.schoolmanagementproject.Service;

import com.example.schoolmanagementproject.DTO.CampusDto;
import com.example.schoolmanagementproject.Entities.Campus;
import com.example.schoolmanagementproject.Entities.StudentClass;
import com.example.schoolmanagementproject.Repository.CampusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class CampusService {
    @Autowired
    private CampusRepository campusRepository;

    @Lazy
    @Autowired
    private StudentClassService studentClassService;

    public Campus createCampus(Campus campus) {
        Campus newCampus = new Campus();
        newCampus.setName(campus.getName());
        newCampus.setAddress(campus.getAddress());
        newCampus.setContactInformation(campus.getContactInformation());
        campusRepository.save(newCampus);
        return newCampus;
    }

    public List<Campus> getAllCampuses() {
        return campusRepository.findAll();
    }

    public Optional<Campus> getCampusById(Long id) {
        return campusRepository.findById(id);
    }

    public CampusDto getCampusWithClassesById(Long id) {
        Campus campus =  campusRepository.findById(id).orElse(null);
        List<?> studentClassList = studentClassService.getAllClassesByCampusId(id);
        return new CampusDto(campus,studentClassList);
    }



    public Campus updateCampus(Long id, Campus updatedCampus) {
        Optional<Campus> campus= getCampusById(id);
        if (campus.isPresent()) {
            Campus existingCampus = campus.get();
            existingCampus.setName(updatedCampus.getName());
            existingCampus.setAddress(updatedCampus.getAddress());
            existingCampus.setContactInformation(updatedCampus.getContactInformation());

            campusRepository.save(existingCampus);
            return existingCampus;
        } else {
            throw new IllegalArgumentException("Campus with ID " + id + " not found");
        }
    }

    public void deleteCampus(Long id) {

        campusRepository.deleteById(id);
    }
}
