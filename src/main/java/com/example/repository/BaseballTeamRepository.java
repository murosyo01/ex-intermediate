package com.example.repository;

import com.example.domain.BaseballTeam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BaseballTeamRepository {
    private static final RowMapper<BaseballTeam> BASEBALL_TEAM_ROW_MAPPER = (rs, i) -> {
        BaseballTeam baseballTeam = new BaseballTeam();
        baseballTeam.setId(rs.getInt("id"));
        baseballTeam.setLeagueName(rs.getString("league_name"));
        baseballTeam.setTeamName(rs.getString("team_name"));
        baseballTeam.setHeadQuarters(rs.getString("headquarters"));
        baseballTeam.setInauguration(rs.getString("inauguration"));
        baseballTeam.setHistory(rs.getString("history"));

        return baseballTeam;
    };

    @Autowired
    private NamedParameterJdbcTemplate template;

    public BaseballTeam findById(Integer id){
        String sql = "SELECT id, league_name, team_name, headquarters, inauguration, history FROM teams WHERE id = :id;";

        SqlParameterSource param = new MapSqlParameterSource().addValue("id", id);

        return template.queryForObject(sql, param, BASEBALL_TEAM_ROW_MAPPER);
    }

    public List<BaseballTeam> findAll(){
        String sql = "SELECT id, league_name, team_name, headquarters, inauguration, history FROM teams ORDER BY inauguration;";
        List<BaseballTeam> baseballTeamList = template.query(sql, BASEBALL_TEAM_ROW_MAPPER);

        if (baseballTeamList.isEmpty()){
            return null;
        }

        return baseballTeamList;
    }
}
