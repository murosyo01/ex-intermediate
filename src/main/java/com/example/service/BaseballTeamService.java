package com.example.service;

import com.example.domain.BaseballTeam;
import com.example.repository.BaseballTeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class BaseballTeamService {

    @Autowired
    private BaseballTeamRepository baseballTeamRepository;

    public BaseballTeam findById(Integer id){
        return baseballTeamRepository.findById(id);
    }

    public List<BaseballTeam> findAll(){
        return baseballTeamRepository.findAll();
    }
}
