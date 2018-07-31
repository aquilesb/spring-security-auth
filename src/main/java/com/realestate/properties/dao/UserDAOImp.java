package com.realestate.properties.dao;

import com.realestate.properties.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;

@Repository
public class UserDAOImp implements UserDAO {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public User insert(User user) {
        KeyHolder holder = new GeneratedKeyHolder();
        String query = "INSERT INTO users (name, email, username, password) VALUES (?, ?, ?, ?)";

        jdbcTemplate.update((Connection connection) -> {
            PreparedStatement ps = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, user.getName());
            ps.setString(2, user.getEmail());
            ps.setString(3, user.getUsername());
            ps.setString(4, user.getPassword());
            return ps;
        }, holder);


//        jdbcTemplate.update(new PreparedStatementCreator() {
//            @Override
//            public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
//                PreparedStatement ps = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
//                ps.setString(1, user.getName());
//                ps.setString(2, user.getEmail());
//                ps.setString(3, user.getUsername());
//                ps.setString(4, user.getPassword());
//                return ps;
//            }
//        }, holder);
//
        user.setId(holder.getKey().longValue());
        return user;
    }

    @Override
    public Boolean isEmailUsed(String email) {
        String query = "SELECT COUNT(*) as qnt FROM users WHERE email = ?";
        return jdbcTemplate.queryForObject(query, new Object[]{email}, (rs, rowNum) -> rs.getInt("qnt") > 0);
    }

    @Override
    public User getUserByID(Long id) {
        String query = "SELECT * FROM users WHERE id = ? ";
        return jdbcTemplate.queryForObject(query, new Object[]{id}, (rs, rowNum) -> {
            User user = new User();
            user.setId(rs.getLong("id"));
            user.setName(rs.getString("name"));
            user.setEmail(rs.getString("email"));
            return user;
        });
    }

    @Override
    public User getUserByUsername(String username) {
        String query = "SELECT * FROM users WHERE username = ? ";
        return jdbcTemplate.queryForObject(query, new Object[]{username}, (rs, rowNum) -> {
            User user = new User();
            user.setId(rs.getLong("id"));
            user.setName(rs.getString("name"));
            user.setEmail(rs.getString("email"));
            user.setPassword(rs.getString("password"));
            user.setUsername(rs.getString("username"));
            return user;
        });
    }

}
