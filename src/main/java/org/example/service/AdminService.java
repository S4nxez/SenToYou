package org.example.service;

import org.example.dao.UserDao;
import org.example.domain.User;

import java.time.LocalDate;

public class AdminService extends UserDao {
    User user = new User(); //aqui en el dc salia userdao creo

    public AdminService(String name, String email, String direccion, LocalDate fecha_nac, String username, String pwd) {
        super(name, email, direccion, fecha_nac, username, pwd);
    }//esto lo pone el intellij pero yo creo que no deberia ir porque igual la herencia esta mal

    private boolean cambiaPrecio(float precio){
        return true;
    }
    private boolean addUser(User usuario){
        return true;
    }

    private boolean borrarUser(User usuario){
        return true;
    }
}
