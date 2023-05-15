package org.example.domain;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;

public class User implements Serializable{
    private String name, email, direccion, username, pwd;
    LocalDate fecha_nac = LocalDate.now();

    public User(String name, String email, String direccion, LocalDate fecha_nac, String username, String pwd) {
        this.name = name;
        this.email = email;
        this.direccion = direccion;
        this.fecha_nac = fecha_nac;
        this.username = username;
        this.pwd = pwd;
        ArrayList<String> Friends = new ArrayList<>();// USAR FRIENNDS AT (AMIGOS QUE YA EXISTAN)   MEJOR ARRAY DE STRINGS usando username como clave primaria
    }

    public User(){}

    public String getUsrName(){
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPwd(){
        return pwd;
    }

    @Override
    public String toString() {
        return "Name: "+name+" E-Mail: "+email+" Address: "+direccion+" Birthdate: "+fecha_nac+" Username: "+username+" Password: "+pwd;
    }
}