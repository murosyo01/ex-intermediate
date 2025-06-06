package com.example.repository;

import com.example.domain.Clothing;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * clothesテーブルを操作するリポジトリ.
 */
@Repository
public class ClothingSearchRepository {
    private static final RowMapper<Clothing> CLOTHING_ROW_MAPPER = (rs, i) -> {
        Clothing clothing = new Clothing();
        clothing.setId(rs.getInt("id"));
        clothing.setCategory(rs.getString("category"));
        clothing.setGenre(rs.getString("genre"));
        clothing.setGender(rs.getInt("gender"));
        clothing.setColor(rs.getString("color"));
        clothing.setPrice(rs.getInt("price"));
        clothing.setSize(rs.getString("size"));

        return clothing;
    };

    @Autowired
    NamedParameterJdbcTemplate template;

    /**
     * 色と性別が一致する衣類を検索.
     * @param color 色
     * @param gender 性別
     * @return 衣類オブジェクトのリスト
     */
    public List<Clothing> searchByColorAndGender(String color, Integer gender){
        String sql = "SELECT id, category, genre, gender, color, price, size FROM clothes WHERE color = :color AND gender = :gender;";

        SqlParameterSource param = new MapSqlParameterSource().addValue("color", color).addValue("gender", gender);

        return template.query(sql, param, CLOTHING_ROW_MAPPER);
    }
}
