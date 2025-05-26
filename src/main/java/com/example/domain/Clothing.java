package com.example.domain;

/**
 * clothes情報を保持するdomainクラス
 */
public class Clothing {
    /** 衣類ID */
    private Integer id;

    /** 衣類ID */
    private String category;

    /** 衣類ID */
    private String genre;

    /** 衣類ID */
    private Integer gender;

    /** 衣類ID */
    private String color;

    /** 衣類ID */
    private Integer price;

    /** 衣類ID */
    private String size;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

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

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    @Override
    public String toString() {
        return "Clothing{" +
                "id=" + id +
                ", category='" + category + '\'' +
                ", genre='" + genre + '\'' +
                ", gender=" + gender +
                ", color='" + color + '\'' +
                ", price=" + price +
                ", size='" + size + '\'' +
                '}';
    }
}
