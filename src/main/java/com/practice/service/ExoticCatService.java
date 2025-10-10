package com.practice.service;

import com.practice.entity.ExoticCat;
import com.practice.repository.ExoticCatRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ExoticCatService {
    
    private final ExoticCatRepository exoticCatRepository;
    
    @Autowired
    public ExoticCatService(ExoticCatRepository exoticCatRepository) {
        this.exoticCatRepository = exoticCatRepository;
    }
    
    // Get all cats
    public List<ExoticCat> getAllCats() {
        return exoticCatRepository.findAll();
    }
    
    // Get cat by ID
    public Optional<ExoticCat> getCatById(Long id) {
        return exoticCatRepository.findById(id);
    }
    
    // Add new cat
    public ExoticCat addCat(ExoticCat cat) {
        return exoticCatRepository.save(cat);
    }
    
    // Update existing cat
    public ExoticCat updateCat(Long id, ExoticCat catDetails) {
        ExoticCat cat = exoticCatRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cat not found with id: " + id));
        
        cat.setName(catDetails.getName());
        cat.setDescription(catDetails.getDescription());
        cat.setBreed(catDetails.getBreed());
        cat.setOrigin(catDetails.getOrigin());
        cat.setSize(catDetails.getSize());
        cat.setLifespan(catDetails.getLifespan());
        cat.setConservationStatus(catDetails.getConservationStatus());
        cat.setCareRequirements(catDetails.getCareRequirements());
        
        return exoticCatRepository.save(cat);
    }
    
    // Delete cat
    public void deleteCat(Long id) {
        exoticCatRepository.deleteById(id);
    }
    
    // Get cats by breed (category search)
    public List<ExoticCat> getCatsByBreed(String breed) {
        return exoticCatRepository.findByBreed(breed);
    }
    
    // Get cats by name containing string
    public List<ExoticCat> getCatsByNameContaining(String name) {
        return exoticCatRepository.findByNameContaining(name);
    }
}