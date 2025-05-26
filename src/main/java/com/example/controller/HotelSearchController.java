package com.example.controller;

import com.example.domain.Hotel;
import com.example.form.HotelSearchForm;
import com.example.service.HotelSearchService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/hotelSearch")
public class HotelSearchController {

    @Autowired
    private HotelSearchService hotelSearchService;

    @GetMapping("")
    public String showSearchHotel(HotelSearchForm hotelSearchForm, Model model){
        model.addAttribute("hotelSearchForm", hotelSearchForm);
        return "searchHotel";
    }

    @PostMapping("/redirect")
    public String searchHotel(@Validated HotelSearchForm hotelSearchForm, BindingResult result, RedirectAttributes redirectAttributes){
        if(result.hasErrors()){
            return "searchHotel";
        }

        List<Hotel> hotelList = hotelSearchService.searchByLessThanPrice(hotelSearchForm.getPrice());
        redirectAttributes.addFlashAttribute("hotelList", hotelList);
        redirectAttributes.addFlashAttribute("hotelSearchForm", hotelSearchForm);

        return "redirect:/hotelSearch";
    }
}
