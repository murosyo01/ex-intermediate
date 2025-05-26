package com.example.controller;

import com.example.domain.Clothing;
import com.example.form.ClothingSearchForm;
import com.example.service.ClothingSearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/clothing")
public class ClothingController {
    @Autowired
    private ClothingSearchService clothingSearchService;

    @GetMapping("")
    public String showSearchClothing(ClothingSearchForm clothingSearchForm, Model model){
        model.addAttribute("clothingSearchForm", clothingSearchForm);
        return "searchClothing";
    }

    @PostMapping("/redirect")
    public String searchCClothing(ClothingSearchForm clothingSearchForm){
        Clothing clothing = clothingSearchService.searchByColorAndGender(clothingSearchForm.getColor(), clothingSearchForm.getGender());

        return "/clothing";
    }
}
