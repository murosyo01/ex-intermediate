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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.List;

/**
 * 衣類に対する操作を指示するコントローラー.
 */
@Controller
@RequestMapping("/clothing")
public class ClothingController {
    @Autowired
    private ClothingSearchService clothingSearchService;

    /**
     * 衣類検索画面の表示.
     * @param clothingSearchForm フォーム
     * @param model モデル
     * @return 検索画面
     */
    @GetMapping("")
    public String showSearchClothing(ClothingSearchForm clothingSearchForm, Model model){
        List<String> genderList = new ArrayList<>();
        genderList.add("Man");
        genderList.add("Woman");

        List<String> colorList = new ArrayList<>();
        colorList.add("赤");
        colorList.add("青");
        colorList.add("白");
        colorList.add("黄");

        if (clothingSearchForm.getGender() == null) {
            clothingSearchForm.setGender(0); // 最初のラジオボタン（Man）をデフォルトで選択
        }

        model.addAttribute("genderList", genderList);
        model.addAttribute("colorList", colorList);
        model.addAttribute("clothingSearchForm", clothingSearchForm);

        return "searchClothing";
    }

    /**
     * 衣類検索の結果を表示.
     * @param clothingSearchForm フォーム
     * @param redirectAttributes  リダイレクト処理
     * @return 検索結果を追加した衣類検索画面.
     */
    @PostMapping("/post")
    public String searchCClothing(ClothingSearchForm clothingSearchForm, RedirectAttributes redirectAttributes){
        List<Clothing> clothingList = clothingSearchService.searchByColorAndGender(clothingSearchForm.getColor(), clothingSearchForm.getGender());

        redirectAttributes.addFlashAttribute("clothingList", clothingList);
        redirectAttributes.addFlashAttribute("clothingSearchForm", clothingSearchForm);

        return "redirect:/clothing";
    }
}
