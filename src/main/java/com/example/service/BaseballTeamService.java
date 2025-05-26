package com.example.service;

import com.example.domain.BaseballTeam;
import com.example.repository.BaseballTeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;

/**
 * ベースボールチームリポジトリを操作するサービス
 */
@Service
@Transactional
public class BaseballTeamService {

    @Autowired
    private BaseballTeamRepository baseballTeamRepository;

    /**
     * 指定したIDをもつ雇用者を検索
     * @param id チームID
     * @return ベースボールチームオブジェクト
     */
    public BaseballTeam findById(Integer id){
        return baseballTeamRepository.findById(id);
    }

    /**
     * 全野球チームを検索
     * @return ベースボールチームオブジェクトのリスト
     */
    public List<BaseballTeam> findAll(){
        return baseballTeamRepository.findAll();
    }
}
