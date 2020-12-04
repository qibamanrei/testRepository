package com.shopping.service.imp;
import com.shopping.bean.User;
import com.shopping.dao.UserDao;
import com.shopping.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImp implements UserService {
    @Autowired
    private UserDao userDao;

    @Override
    public boolean regist(User user) {
        int result = userDao.add(user);
        if(result == 1){
            return true;
        }
        return false;
    }

    @Override
    public User login(String username, String password) {
        return userDao.foundUser(username, password);
    }
}
