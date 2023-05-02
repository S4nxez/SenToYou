package org.example.domain;

import java.time.LocalDate;
import java.util.ArrayList;

public class User {
    String name, email, direccion, username, pwd;
    LocalDate fecha_nac = LocalDate.now();


    public boolean sendPackage(Package Package, String nombreReceptor){
        return;
    }
    private String getEstadoPaquete(String paquete_id){// este metodo igual nos colamos en el DC al ponerlo aqui creo que tendria que estar en paquete en la carpeta domain
        return ;
    }
    private boolean addFriend(User amigo){
        return ;
    }
    private boolean removeFriend(User amigo){
        return ;
    }

    public User(String name, String email, String direccion, LocalDate fecha_nac, String username, String pwd) {
        this.name = name;
        this.email = email;
        this.direccion = direccion;
        this.fecha_nac = fecha_nac;
        this.username = username;
        this.pwd = pwd;
        ArrayList<User> Friends = new ArrayList();
    }
}