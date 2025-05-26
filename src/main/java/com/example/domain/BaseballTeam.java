package com.example.domain;

import java.util.Date;
import java.util.List;

public class BaseballTeam {
    private Integer id;
    private String leagueName;
    private String teamName;
    private String headQuarters;
    private Date inauguration;
    private String history;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLeagueName() {
        return leagueName;
    }

    public void setLeagueName(String leagueName) {
        this.leagueName = leagueName;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public String getHeadQuarters() {
        return headQuarters;
    }

    public void setHeadQuarters(String headQuarters) {
        this.headQuarters = headQuarters;
    }

    public Date getInauguration() {
        return inauguration;
    }

    public void setInauguration(Date inauguration) {
        this.inauguration = inauguration;
    }

    public String getHistory() {
        return history;
    }

    public void setHistory(String history) {
        this.history = history;
    }

    @Override
    public String toString() {
        return "BaseballTeam{" +
                "id=" + id +
                ", leagueName='" + leagueName + '\'' +
                ", teamName='" + teamName + '\'' +
                ", headQuarters='" + headQuarters + '\'' +
                ", inauguration=" + inauguration +
                ", history='" + history + '\'' +
                '}';
    }
}
