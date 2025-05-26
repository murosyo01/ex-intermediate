package com.example.repository;

import com.example.domain.BaseballTeam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

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

    public BaseballTeam findByTeamName(String teamName){
        String sql = "SELECT id, league_name, team_name, headquarters, inauguration, history FROM teams WHERE team_name = :teamName;";

        SqlParameterSource param = new MapSqlParameterSource().addValue("teamName", teamName);

        return template.queryForObject(sql, param, BASEBALL_TEAM_ROW_MAPPER);
    }
}
