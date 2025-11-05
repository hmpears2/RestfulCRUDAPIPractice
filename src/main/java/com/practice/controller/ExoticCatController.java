package com.practice.controller;

import com.practice.entity.ExoticCat;
import com.practice.service.ExoticCatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/cats")
public class ExoticCatController {
    
    private final ExoticCatService exoticCatService;
    
    @Autowired
    public ExoticCatController(ExoticCatService exoticCatService) {
        this.exoticCatService = exoticCatService;
    }
    
    // View: Get all cats (displays cat-list.ftlh)
    @GetMapping
    public String getAllCats(Model model) {
        List<ExoticCat> cats = exoticCatService.getAllCats();
        model.addAttribute("catList", cats);
        return "cat-list";
    }
    
    // View: Get one cat by ID (displays cat-details.ftlh)
    @GetMapping("/{id}")
    public String getCatById(@PathVariable Long id, Model model, RedirectAttributes redirectAttributes) {
        Optional<ExoticCat> catOptional = exoticCatService.getCatById(id);
        
        if (catOptional.isEmpty()) {
            // Cat not found - redirect to list with error message
            redirectAttributes.addFlashAttribute("errorMessage", 
                "Cat with ID " + id + " not found.");
            return "redirect:/cats";
        }
        
        model.addAttribute("cat", catOptional.get());
        return "cat-details";
    }
    
    // View: Show create form (displays cat-create.ftlh)
    @GetMapping("/new")
    public String showCreateForm() {
        return "cat-create";
    }
    
    // Action: Handle create form submission
    @PostMapping("/new")
    public String createCat(ExoticCat cat, RedirectAttributes redirectAttributes) {
        ExoticCat savedCat = exoticCatService.addCat(cat);
        redirectAttributes.addFlashAttribute("successMessage", 
            "Cat '" + savedCat.getName() + "' added successfully!");
        return "redirect:/cats/" + savedCat.getExoticCatId();
    }
    
    // View: Show update form (displays cat-update.ftlh)
    @GetMapping("/update/{id}")
    public String showUpdateForm(@PathVariable Long id, Model model, RedirectAttributes redirectAttributes) {
        Optional<ExoticCat> catOptional = exoticCatService.getCatById(id);
        
        if (catOptional.isEmpty()) {
            // Cat not found - redirect to list with error message
            redirectAttributes.addFlashAttribute("errorMessage", 
                "Cat with ID " + id + " not found.");
            return "redirect:/cats";
        }
        
        model.addAttribute("cat", catOptional.get());
        return "cat-update";
    }
    
    // Action: Handle update form submission
    @PostMapping("/update")
    public String updateCat(ExoticCat cat, RedirectAttributes redirectAttributes) {
        try {
            ExoticCat updatedCat = exoticCatService.updateCat(cat.getExoticCatId(), cat);
            redirectAttributes.addFlashAttribute("successMessage", 
                "Cat '" + updatedCat.getName() + "' updated successfully!");
            return "redirect:/cats/" + updatedCat.getExoticCatId();
        } catch (RuntimeException e) {
            redirectAttributes.addFlashAttribute("errorMessage", 
                "Error updating cat: " + e.getMessage());
            return "redirect:/cats";
        }
    }
    
    // Action: Delete cat
    @GetMapping("/delete/{id}")
    public String deleteCat(@PathVariable Long id, RedirectAttributes redirectAttributes) {
        try {
            Optional<ExoticCat> catOptional = exoticCatService.getCatById(id);
            
            if (catOptional.isEmpty()) {
                redirectAttributes.addFlashAttribute("errorMessage", 
                    "Cat with ID " + id + " not found.");
                return "redirect:/cats";
            }
            
            String catName = catOptional.get().getName();
            exoticCatService.deleteCat(id);
            redirectAttributes.addFlashAttribute("successMessage", 
                "Cat '" + catName + "' deleted successfully!");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("errorMessage", 
                "Error deleting cat: " + e.getMessage());
        }
        return "redirect:/cats";
    }
    
    // EXTRA CREDIT: Get cats by breed
    @GetMapping("/breed/{breed}")
    public String getCatsByBreed(@PathVariable String breed, Model model) {
        List<ExoticCat> cats = exoticCatService.getCatsByBreed(breed);
        model.addAttribute("catList", cats);
        model.addAttribute("filterType", "breed");
        model.addAttribute("filterValue", breed);
        return "cat-list";
    }
    
    // EXTRA CREDIT: Search cats by name
    @GetMapping("/search")
    public String searchCatsByName(@RequestParam String name, Model model) {
        List<ExoticCat> cats = exoticCatService.getCatsByNameContaining(name);
        model.addAttribute("catList", cats);
        model.addAttribute("filterType", "search");
        model.addAttribute("filterValue", name);
        return "cat-list";
    }
}