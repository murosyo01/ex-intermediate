package com.example.form;

/**
 * 衣類情報を受け取るフォーム
 */
public class ClothingSearchForm {
    /** 性別 */
    private Integer gender;
    /** 色 */
    private String color;

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "ClothingSearch{" +
                "gender=" + gender +
                ", color='" + color + '\'' +
                '}';
    }
}
