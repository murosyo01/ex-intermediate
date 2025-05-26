package com.example.controller;

import com.example.domain.BaseballTeam;
import com.example.service.BaseballTeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * ベースボールチームに対する操作を指示するコントローラー.
 */
@Controller
@RequestMapping("/baseball")
public class BaseballTeamListController {

    @Autowired
    private BaseballTeamService baseballTeamService;

    /**
     * 全ての野球チームを表示.
     * @param model モデル
     * @return ベースボールチームリスト
     */
    @GetMapping("")
    public String showList(Model model){
        List<BaseballTeam> baseballTeamList = baseballTeamService.findAll();
        model.addAttribute("teamList", baseballTeamList);
        return "showTeamList";
    }

    /**
     * 選択した野球チームの情報を表示
     * @param id チームID
     * @param model モデル
     * @return idに基づくベースボールチームオブジェクト
     */
    @GetMapping("/showDetail")
    public String showDetail(String id, Model model){
        BaseballTeam baseballTeam = baseballTeamService.findById(Integer.parseInt(id));

        model.addAttribute("team", baseballTeam);

        return "showDetail";
    }
}
