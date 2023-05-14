package org.example.service;

import org.example.domain.User;

import java.time.LocalDate;
//esta clase no tiene sentido
public class AdminService {
    User user = new User(); //aqui en el dc salia userdao creo

    public AdminService(String name, String email, String direccion, LocalDate fecha_nac, String username, String pwd) {}
    public AdminService() {}


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
