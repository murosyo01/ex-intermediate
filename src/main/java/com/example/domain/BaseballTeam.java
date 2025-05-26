package com.example.domain;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BaseballTeam {
    private Integer id;
    private String leagueName;
    private String teamName;
    private String headQuarters;
    private LocalDate inauguration;
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

    public LocalDate getInauguration() {
        return inauguration;
    }

    public void setInauguration(String inauguration) {
        this.inauguration  = parseInaugurationDate(inauguration);
    }

    private LocalDate parseInaugurationDate(String dateStr) {
        if (dateStr == null || dateStr.trim().isEmpty()) {
            return null; // Nullまたは空文字列の場合はnullを返す
        }
        Pattern pattern = Pattern.compile("(\\d{4})年(\\d{1,2})月(\\d{1,2})日");
        Matcher matcher = pattern.matcher(dateStr);

        if (matcher.find()) {
            try {
                int year = Integer.parseInt(matcher.group(1));
                int month = Integer.parseInt(matcher.group(2));
                int day = Integer.parseInt(matcher.group(3));
                return LocalDate.of(year, month, day);
            } catch (NumberFormatException e) {
                System.err.println("日付の数値パースエラー (Inauguration): " + dateStr + " - " + e.getMessage());
                return null;
            }
        }
        System.err.println("日付のフォーマットに合致しません (Inauguration): " + dateStr);
        return null;
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
