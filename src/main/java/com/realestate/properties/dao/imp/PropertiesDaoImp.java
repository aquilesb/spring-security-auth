package com.realestate.properties.dao.imp;

import com.realestate.properties.dao.PropertiesDao;
import com.realestate.properties.domain.Properties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PropertiesDaoImp implements PropertiesDao {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public List<Properties> getFeaturedProperties() {
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT ");
        sb.append(" id, ");
        sb.append(" name, ");
        sb.append(" address, ");
        sb.append(" google_maps, ");
        sb.append(" encoded_url, ");
        sb.append(" price, ");
        sb.append(" status, ");
        sb.append(" description, ");
        sb.append(" bedrooms, ");
        sb.append(" bathrooms, ");
        sb.append(" parking, ");
        sb.append(" kitchen ");
        sb.append(" FROM properties ");
        sb.append(" WHERE dt_deleted is null ");

        List<Properties> result = jdbcTemplate.query(sb.toString(), (rs, i) -> {
            Properties prop = new Properties();
            prop.setId(rs.getInt("id"));
            prop.setName(rs.getString("name"));
            prop.setAddress(rs.getString("address"));
            prop.setGoogleMaps(rs.getString("google_maps"));
            prop.setEncodedURL(rs.getString("encoded_url"));
            prop.setPrice(rs.getBigDecimal("price"));
            prop.setStatus(rs.getString("status"));
            prop.setDescription(rs.getString("description"));
            prop.setBedrooms(rs.getInt("bedrooms"));
            prop.setBathrooms(rs.getInt("bathrooms"));
            prop.setKitchen(rs.getInt("kitchen"));
            prop.setParking(rs.getInt("parking"));
            return prop;
        });

        return result;
    }
}
