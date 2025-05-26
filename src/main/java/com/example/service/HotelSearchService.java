package com.example.service;

import com.example.domain.Hotel;
import com.example.repository.HotelSearchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * ホテルリポジトリを操作するサービス.
 */
@Service
public class HotelSearchService {

    @Autowired
    private HotelSearchRepository hotelSearchRepository;

    /**
     * 指定したPrice以下のホテルを検索.
     * @param price 価格
     * @return ホテルオブジェクト
     */
    public List<Hotel> searchByLessThanPrice(Integer price){
        return hotelSearchRepository.searchByLessThanPrice(price);
    }
}
