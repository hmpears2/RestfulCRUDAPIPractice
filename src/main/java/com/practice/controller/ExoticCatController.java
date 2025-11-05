package com.practice.controller;

import com.practice.entity.ExoticCat;
import com.practice.service.ExoticCatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public String getCatById(@PathVariable Long id, Model model) {
        ExoticCat cat = exoticCatService.getCatById(id)
                .orElseThrow(() -> new RuntimeException("Cat not found with id: " + id));
        model.addAttribute("cat", cat);
        return "cat-details";
    }
    
    // View: Show created form (displays cat-create.ftlh)
    @GetMapping("/new")
    public String showCreateForm() {
        return "cat-create";
    }
    
    // Handle create form submission (action)
    @PostMapping("/new")
    public String createCat(ExoticCat cat) {
        ExoticCat savedCat = exoticCatService.addCat(cat);
        return "redirect:/cats/" + savedCat.getExoticCatId();
    }

    // View: Show updated form (displays cat-update.ftlh)
    @GetMapping("/update/{id}")
    public String showUpdateForm(@PathVariable Long id, Model model) {
        ExoticCat cat = exoticCatService.getCatById(id)
                .orElseThrow(() -> new RuntimeException("Cat not found with id: " + id));
        model.addAttribute("cat", cat);
        return "cat-update";
    }
    
    // Handle update form submission (action)
    @PostMapping("/update")
    public String updateCat(ExoticCat cat) {
        ExoticCat updatedCat = exoticCatService.updateCat(cat.getExoticCatId(), cat);
        return "redirect:/cats/" + updatedCat.getExoticCatId();
    }
    
    // Delete cat (action)
    @GetMapping("/delete/{id}")
    public String deleteCat(@PathVariable Long id) {
        exoticCatService.deleteCat(id);
        return "redirect:/cats";
    }

    // Search cats by breed
    @GetMapping("/breed/{breed}")
    public String getCatsByBreed(@PathVariable String breed, Model model) {
        List<ExoticCat> cats = exoticCatService.getCatsByBreed(breed);
        model.addAttribute("catList", cats);
        model.addAttribute("filterType", "breed");
        model.addAttribute("filterValue", breed);
        return "cat-list";
    }
    
    // Search cats by name
    @GetMapping("/search")
    public String searchCatsByName(@RequestParam String name, Model model) {
        List<ExoticCat> cats = exoticCatService.getCatsByNameContaining(name);
        model.addAttribute("catList", cats);
        model.addAttribute("filterType", "search");
        model.addAttribute("filterValue", name);
        return "cat-list";
    }
}