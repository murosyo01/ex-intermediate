package com.example.service;

import com.example.domain.Clothing;
import com.example.repository.ClothingSearchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 衣類リポジトリを操作するサービス.
 */
@Service
public class ClothingSearch {
    @Autowired
    private ClothingSearchRepository clothingSearchRepository;

    public Clothing searchByColorAndGender(String color, Integer gender){

    }
}
