package com.shopping.dao;

import com.shopping.bean.User;

public interface UserDao {
    public int add(User user);
    public User foundUser(String username, String password);
}
