package org.example.dao;

import org.example.domain.Paquete;
import org.example.domain.User;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class SentToYouDao {
    protected ArrayList<Paquete> paquetes;
    //El arraylist de todos los usuarios
    protected ArrayList<User> comunidad;

    public SentToYouDao() {
        paquetes= new ArrayList<>();
        comunidad=new ArrayList<>();
    }

    //Método que te devuelve un usuario a partir de su nombre
    public User getUser(String username){
        User usReturn = new User(null,null,null,null,null,null);
        for (User user : comunidad) {
            if (user.getUsrName().equals(username))
                usReturn = user;
        }
        return usReturn;
    }
    public String listarAmigos(String username) {
        String respuesta ="";
        for (int i = 0; i < getUser(username).getFriends().size(); i++) {
            respuesta=respuesta+getUser(username).getFriends().get(i)+",";
        }
        return respuesta;
    }


    public boolean esAmigo(String solicitante, String solicitado) {
        boolean returneo = false;
        if (getUser(solicitante).getFriends() != null) {
            for (String i : getUser(solicitante).getFriends()) {
                if (i.equalsIgnoreCase(solicitado)) {
                    returneo = true;
                    break;
                }
            }
        }
        return returneo;
    }
    public boolean addFriend(String solicitante, String amigo){
        User usr = getUser(solicitante);
        boolean returneo = false;
        if(esAmigo(solicitante,amigo)){
            if(getUser(amigo).getUsrName()!=null){
                returneo = true;
            }
        }
        if (returneo){
            ArrayList<String> friendsUpdt = getUser(solicitante).getFriends();
            friendsUpdt.add(amigo);
            getUser(solicitante).setFriends(friendsUpdt);
        }
        for (User u : comunidad) {
            if (u.getUsrName().equalsIgnoreCase(solicitante)){
                comunidad.remove(u);
                System.out.println(usr.getFriends());
                comunidad.add(usr);
                break;
            }
        }
        return returneo;
    }
}

