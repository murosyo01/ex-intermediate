package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/baseball")
public class baseballTeamListController {

    @GetMapping("")
    public String showList(){
        return "showTeamList";
    }

    @PostMapping("/showDetail")
    public String showDetail(){
        return "showDetail";
    }
}
