package org.example.service;

import org.example.dao.UserDao;
import org.example.domain.User;

import java.util.Date;

public class UserService extends UserDao{
    UserDao userDao = new UserDao();
    private boolean login(String username, String pwd){
        if (userDao.Username.equals(username)&&userDao.pwd.equals(pwd)){
            return true;
        }
        else return false;
    }
    private boolean register(String name, String dir, String email, Date fechaNac, String usrname, String Password){
        return ;
    }
    public User getUser(String username){
        return;
    }
    private void updateUser(User user){}
}
