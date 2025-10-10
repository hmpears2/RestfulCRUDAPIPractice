package com.practice.controller;

import com.practice.entity.ExoticCat;
import com.practice.service.ExoticCatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cats")
@CrossOrigin(origins = "*") // Allow frontend to connect
public class ExoticCatController {
    
    private final ExoticCatService exoticCatService;
    
    @Autowired
    public ExoticCatController(ExoticCatService exoticCatService) {
        this.exoticCatService = exoticCatService;
    }
    
    // Get all cats
    @GetMapping
    public ResponseEntity<List<ExoticCat>> getAllCats() {
        return ResponseEntity.ok(exoticCatService.getAllCats());
    }
    
    // Get cat by ID
    @GetMapping("/{id}")
    public ResponseEntity<ExoticCat> getCatById(@PathVariable Long id) {
        return exoticCatService.getCatById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
    
    // Add new cat (handles form submission from new-animal-form.html)
    @PostMapping
    public ResponseEntity<ExoticCat> addCat(@RequestBody ExoticCat cat) {
        ExoticCat savedCat = exoticCatService.addCat(cat);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedCat);
    }
    
    // Update existing cat
    @PutMapping("/{id}")
    public ResponseEntity<ExoticCat> updateCat(@PathVariable Long id, @RequestBody ExoticCat cat) {
        try {
            ExoticCat updatedCat = exoticCatService.updateCat(id, cat);
            return ResponseEntity.ok(updatedCat);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
    
    // Delete cat
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCat(@PathVariable Long id) {
        exoticCatService.deleteCat(id);
        return ResponseEntity.noContent().build();
    }
    
    // Get cats by breed (for category filtering - matches your breed attribute)
    @GetMapping("/breed/{breed}")
    public ResponseEntity<List<ExoticCat>> getCatsByBreed(@PathVariable String breed) {
        return ResponseEntity.ok(exoticCatService.getCatsByBreed(breed));
    }
    
    // Get cats whose name contains a string (for search functionality)
    @GetMapping("/search")
    public ResponseEntity<List<ExoticCat>> searchCatsByName(@RequestParam String name) {
        return ResponseEntity.ok(exoticCatService.getCatsByNameContaining(name));
    }
}