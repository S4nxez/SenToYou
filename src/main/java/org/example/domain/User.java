package org.example.domain;

import org.example.dao.UserDao;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

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
        fecha_nac = LocalDate.parse(campos[3], DateTimeFormatter.ofPattern("yyyy-dd-MM"));
        username = campos[4];
        pwd = campos[5];
        String linea2 = campos[6];
        String[] amigos = linea2.split(", ");
        if (Friends==null){
            Friends=new ArrayList<>();
            Friends.add("BUG");
        }
        Collections.addAll(Friends, amigos);
    }
    public ArrayList<String> getFriends() {
        return Friends;
    }

    public String getUsrName(){
        return username;
    }
    public String getName(){
        return name;
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
        return name+":"+email+":"+direccion+":"+fecha_nac+":"+username+":"+pwd+/*":"+usrdao.listarAmigos(username)+*/":"+friendsToString(Friends.toString());
    }
    private String friendsToString(String input){
        String[] elements = input.substring(1, input.length() - 1).split(", ");
        StringBuilder output = new StringBuilder();
        for (int i = 1; i < elements.length; i++) {
            output.append(elements[i]);
            if (i < elements.length - 1) {
                output.append(", ");
            }
        }
        return output.toString();
    }
    public void setFriends(String amigo) {
        if (Friends==null)Friends=new ArrayList<>();
        this.Friends.add(amigo);
    }

    public void setNombre(String nombre) {
        this.name = nombre;
    }

    public void setUsrname(String usrname) {
        this.username=usrname;
    }
}