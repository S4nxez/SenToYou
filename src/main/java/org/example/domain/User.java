package org.example.domain;

import org.example.dao.UserDao;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class User implements Serializable{
    private String name, email, direccion, username, pwd;
    LocalDate fecha_nac = LocalDate.now();
    ArrayList<String> Friends;

    UserDao usrdao = new UserDao();
    public User(String name, String email, String direccion, LocalDate fecha_nac, String username, String pwd) {
        this.name = name;
        this.email = email;
        this.direccion = direccion;
        this.fecha_nac = fecha_nac;
        this.username = username;
        this.pwd = pwd;
        Friends = new ArrayList<>();// USAR FRIENNDS AT (AMIGOS QUE YA EXISTAN)   MEJOR ARRAY DE STRINGS usando username como clave primaria
    }

    //cargando el usuario desde el archivo de texto
    public User(String linea){
        //creamos array de string en el que se van a almacenar las variables
        String[] campos = linea.split(":");
        //Igualamos el valor de la seccion a la variable local
        name = campos[0];
        email = campos[1];
        direccion = campos[2];
        //Convertir fecha_nac a LocalDate
        fecha_nac = LocalDate.parse(campos[3], DateTimeFormatter.ofPattern("yyyy-dd-MM"));
        username = campos[4];
        pwd = campos[5];
    }
    public ArrayList<String> getFriends() {
        return Friends;
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
        return name+":"+email+":"+direccion+":"+fecha_nac+":"+username+":"+pwd+":"+usrdao.listarAmigos(username);
    }

    public void setFriends(ArrayList<String> Friends) {
        this.Friends = Friends;
    }
}