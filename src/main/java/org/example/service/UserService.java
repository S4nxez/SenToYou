package org.example.service;

import org.example.dao.UserDao;
import org.example.domain.User;

import java.util.ArrayList;
import java.util.Date;

public class UserService{//aqui ponia extends userdao en rojo
    User user = new User();//aqui en el dc salia userdao creo
    public static boolean login(String username, String pwd, User usuario){
        if (usuario.getUsrName().equals(username)&&usuario.getPwd().equals(pwd)){
            return true;
        }
        else return false;
    }
    private boolean register(String name, String dir, String email, Date fechaNac, String usrname, String Password){
        return false;
    }
    public static User findByUsername(String username, ArrayList<User> comunidad){
        User usReturn = new User();
        for (int i = 0; i < comunidad.size(); i++) {
            if (comunidad.get(i).getUsrName().equals(username))usReturn=comunidad.get(i);
        }
        return usReturn;
    }
    private void updateUser(User user){}
}
