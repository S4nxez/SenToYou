package org.example.domain;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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

    public User(String linea){
        String[] campos = linea.split(":");
        name = campos[0];
        email = campos[1];
        direccion = campos[2];
        //Convertir fecha_nac a LocalDate
        fecha_nac = LocalDate.parse(campos[3], DateTimeFormatter.ofPattern("yyyy-dd-MM"));
        username = campos[4];
        pwd = campos[5];
    }


    public String getUsrName(){
        return username;
    }

    public String getEmail() {
        return email;
    }

    public String getPwd(){
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }
    
    @Override
    public String toString() {
        return name+":"+email+":"+direccion+":"+fecha_nac+":"+username+":"+pwd+":";
    }
}