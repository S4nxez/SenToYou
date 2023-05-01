package org.example.service;

import org.example.dao.UserDao;

public class UserService {
    UserDao userDao = new UserDao();
    private boolean login(String username, String pwd){
        if (userDao.Username.equals(username)&&userDao.pwd.equals(pwd)){
            return true;
        }
        else return false;
    }
}
