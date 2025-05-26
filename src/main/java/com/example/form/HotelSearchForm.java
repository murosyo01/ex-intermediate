package com.example.form;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Range;

/**
 * ホテル情報を受け取るフォーム
 */
public class HotelSearchForm {
    /** 価格 */
    @Range(min=0, max=1000000, message = "価格は0円以上～1000000円以下にしてください")
    @NotNull(message = "金額を入力してください")
    private Integer price;

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "HotelSearchForm{" +
                "price=" + price +
                '}';
    }
}
