package com.shopping.service;

import com.shopping.bean.User;

public interface UserService {
    public boolean regist(User user);
    public User login(String username, String password);
}
