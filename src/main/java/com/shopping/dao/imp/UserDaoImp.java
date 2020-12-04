package com.shopping.dao.imp;

import com.shopping.bean.User;
import com.shopping.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;

@Repository
public class UserDaoImp implements UserDao {
    @Autowired
    private JdbcTemplate template;

    @Override
    public int add(User user) {
        int result = 0;
        String sql = "insert into user(username, password, email, name, sex, birthday)values(?,?,?,?,?,?)";
        result = template.update(sql, user.getUsername(), user.getPassword(), user.getEmail(), user.getName(),
                user.getSex(), user.getBirthday());
        return result;
    }

    @Override
    public User foundUser(String username, String password) {
        String sql = "select userid, username , password , sex , name , email , birthday " +
                " from user where username = ? and password = ?;";
        try {
            return template.queryForObject(sql, new RowMapper<User>() {
                @Override
                public User mapRow(ResultSet resultSet, int i) throws SQLException {
                    User user = new User();
                    user.setUserId(resultSet.getInt("userid"));
                    user.setUsername(resultSet.getString("username"));
                    user.setPassword(resultSet.getString("password"));
                    user.setSex(resultSet.getString("sex"));
                    user.setName(resultSet.getString("name"));
                    user.setEmail(resultSet.getString("email"));
                    user.setBirthday(resultSet.getDate("birthday"));
                    return user;
                }
            }, username, password);
        } catch (Exception e) {
            return null;
        }
    }
}
