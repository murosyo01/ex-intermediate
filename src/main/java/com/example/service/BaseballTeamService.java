package com.example.service;

import com.example.domain.BaseballTeam;
import com.example.repository.BaseballTeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class BaseballTeamService {

    @Autowired
    private BaseballTeamRepository baseballTeamRepository;

    public BaseballTeam findByTeamName(String teamName){
        return baseballTeamRepository.findByTeamName(teamName);
    }
}
