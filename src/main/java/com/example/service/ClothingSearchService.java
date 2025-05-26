package com.example.service;

import com.example.domain.Clothing;
import com.example.repository.ClothingSearchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 衣類リポジトリを操作するサービス.
 */
@Service
public class ClothingSearchService {
    @Autowired
    private ClothingSearchRepository clothingSearchRepository;

    /**
     * 指定した色かつ性別の衣類を検索.
     * @param color 色
     * @param gender 性別
     * @return 衣類オブジェクトのリスト
     */
    public List<Clothing> searchByColorAndGender(String color, Integer gender){
        return clothingSearchRepository.searchByColorAndGender(color, gender);
    }
}
