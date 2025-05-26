package com.example.repository;

import com.example.domain.BaseballTeam;
import com.example.domain.Hotel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class HotelSearchRepository {
    private static final RowMapper<Hotel> HOTEL_ROW_MAPPER = (rs, i) -> {
        Hotel hotel = new Hotel();
        hotel.setId(rs.getInt("id"));
        hotel.setAreaName(rs.getString("area_name"));
        hotel.setHotelName(rs.getString("hotel_name"));
        hotel.setAddress(rs.getString("address"));
        hotel.setNearestStation(rs.getString("nearest_station"));
        hotel.setPrice(rs.getInt("price"));
        hotel.setParking(rs.getString("parking"));

        return hotel;
    };

    @Autowired
    private NamedParameterJdbcTemplate template;

    /**
     * 値段以下のホテルを検索
     * @param price 価格
     * @return 価格以下のホテルオブジェクトのリスト
     */
    public List<Hotel> findByPrice(Integer price){
        String sql = "SELECT id, area_name, hotel_name, address, nearest_station, price, parking FROM teams WHERE price <= :price;";
        List<Hotel> hotelList = template.query(sql, HOTEL_ROW_MAPPER);

        SqlParameterSource param = new MapSqlParameterSource().addValue("price", price);

        return template.query(sql, param, HOTEL_ROW_MAPPER);
    }
}
