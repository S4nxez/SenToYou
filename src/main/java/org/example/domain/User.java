package org.example.domain;

import java.time.LocalDate;
import java.util.ArrayList;

public class User {
    private String name, email, direccion, username, pwd;
    LocalDate fecha_nac = LocalDate.now();

    public boolean sendPackage(Package Package, String nombreReceptor){
        return true;
    }

    private String getEstadoPaquete(String paquete_id){// este metodo igual nos colamos en el DC al ponerlo aqui creo que tendria que estar en paquete en la carpeta domain
        return "";
    }

    private boolean addFriend(User amigo){
        return true;
    }
    private boolean removeFriend(User amigo){
        return true;
    }
    public String getUsrName(){
        return name;
    }

    public String getPwd(){
        return pwd;
    }

    public User(String name, String email, String direccion, LocalDate fecha_nac, String username, String pwd) {
        this.name = name;
        this.email = email;
        this.direccion = direccion;
        this.fecha_nac = fecha_nac;
        this.username = username;
        this.pwd = pwd;
        ArrayList<String> Friends = new ArrayList();// USAR FRIENNDS AT (AMIGOS QUE YA EXISTAN)   MEJOR ARRAY DE STRINGS usando username como clave primaria
    }

    public User(){
    }
}