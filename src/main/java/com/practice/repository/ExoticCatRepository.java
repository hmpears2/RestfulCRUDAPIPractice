package com.practice.repository;

import com.practice.entity.ExoticCat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExoticCatRepository extends JpaRepository<ExoticCat, Long> {
    
    // Custom query to find cats by breed (category search requirement)
    List<ExoticCat> findByBreed(String breed);
    
    // Custom query to find cats whose name contains a string (case-insensitive)
    @Query("SELECT c FROM Cat c WHERE LOWER(c.name) LIKE LOWER(CONCAT('%', :name, '%'))")
    List<ExoticCat> findByNameContaining(@Param("name") String name);
}