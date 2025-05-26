package com.example.controller;

import com.example.domain.BaseballTeam;
import com.example.service.BaseballTeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/baseball")
public class baseballTeamListController {

    @Autowired
    private BaseballTeamService baseballTeamService;

    @GetMapping("")
    public String showList(Model model){
        List<BaseballTeam> baseballTeamList = baseballTeamService.findAll();
        model.addAttribute("teamList", baseballTeamList);
        return "showTeamList";
    }

    @GetMapping("/showDetail")
    public String showDetail(String id, Model model){
        BaseballTeam baseballTeam = baseballTeamService.findById(Integer.parseInt(id));

        model.addAttribute("team", baseballTeam);

        return "showDetail";
    }
}
