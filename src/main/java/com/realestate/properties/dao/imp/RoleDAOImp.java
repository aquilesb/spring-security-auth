package com.realestate.properties.dao.imp;

import com.realestate.properties.dao.RoleDAO;
import com.realestate.properties.domain.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class RoleDAOImp implements RoleDAO {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public void insert2User(Long userID, Long roleID) {
        String query = "INSERT INTO user_roles (user_id, role_id) VALUES (?, ?)";
        jdbcTemplate.update(query, new Object[]{userID, roleID});
    }

    @Override
    public List<Role> getUserRoles(Long userID) {
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT r.* FROM roles r ");
        sql.append("LEFT JOIN user_roles ur ON r.id = ur.role_id ");
        sql.append("WHERE ur.user_id = ? ");

        return jdbcTemplate.query(sql.toString(), new Object[]{userID}, new RoleRowMapper());
    }

    private static class RoleRowMapper implements RowMapper<Role> {
        public Role mapRow(ResultSet rs, int rownum) throws SQLException {
            Role role = new Role();
            role.setId(rs.getLong("id"));
            role.setName(rs.getString("name"));
            return role;
        }
    }
}
