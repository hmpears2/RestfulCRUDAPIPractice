package com.practice.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "exotic_cats")
public class ExoticCat {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long exoticCatId;
    
    @Column(nullable = false)
    private String name;
    
    @Column(nullable = false, length = 1000)
    private String description;
    
    @Column(nullable = false)
    private String breed;
    
    @Column(nullable = false)
    private String origin;
    
    @Column(nullable = false)
    private String size;
    
    @Column(nullable = false)
    private String lifespan;
    
    private String conservationStatus;
    
    @Column(length = 1000)
    private String careRequirements;
    
    // Constructors
    public ExoticCat() {}

    public ExoticCat(String name, String description, String breed, String origin,
               String size, String lifespan, String conservationStatus, String careRequirements) {
        this.name = name;
        this.description = description;
        this.breed = breed;
        this.origin = origin;
        this.size = size;
        this.lifespan = lifespan;
        this.conservationStatus = conservationStatus;
        this.careRequirements = careRequirements;
    }
    
    // Getters and Setters
    public Long getExoticCatId() {
        return exoticCatId;
    }

    public void setExoticCatId(Long exoticCatId) {
        this.exoticCatId = exoticCatId;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public String getDescription() {
        return description;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }
    
    public String getBreed() {
        return breed;
    }
    
    public void setBreed(String breed) {
        this.breed = breed;
    }
    
    public String getOrigin() {
        return origin;
    }
    
    public void setOrigin(String origin) {
        this.origin = origin;
    }
    
    public String getSize() {
        return size;
    }
    
    public void setSize(String size) {
        this.size = size;
    }
    
    public String getLifespan() {
        return lifespan;
    }
    
    public void setLifespan(String lifespan) {
        this.lifespan = lifespan;
    }
    
    public String getConservationStatus() {
        return conservationStatus;
    }
    
    public void setConservationStatus(String conservationStatus) {
        this.conservationStatus = conservationStatus;
    }
    
    public String getCareRequirements() {
        return careRequirements;
    }
    
    public void setCareRequirements(String careRequirements) {
        this.careRequirements = careRequirements;
    }
}