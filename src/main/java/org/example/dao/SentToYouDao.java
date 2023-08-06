package org.example.dao;

import org.example.domain.Paquete;
import org.example.domain.User;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class SentToYouDao {
    protected List<Paquete> paquetes;
    protected List<User> comunidad = new ArrayList<>();

    public SentToYouDao() {
        paquetes= new ArrayList<>();
    }

    public User getUser(String username){
        User usReturn = new User(null,null,null,null,null,null);
        for (User user : comunidad) {
            if (user.getUsrName().equals(username))
                usReturn = user;
        }
        return usReturn;
    }
    public String listarAmigos(String username) {
        StringBuilder respuesta = new StringBuilder();
        /*for (int i = 0; i < getUser(username).getFriends().size(); i++) {
            respuesta.append(getUser(username).getFriends().get(i)).append(",");
        }*/
        for (String u: getUser(username).getFriends()) {
            respuesta.append(u).append(",");
        }
        return respuesta.toString();
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
        boolean returneo = !esAmigo(solicitante, amigo) && getUser(amigo).getUsrName() != null;
        if (returneo){
            ArrayList<String> friendsUpdt = getUser(solicitante).getFriends();
            if (friendsUpdt==null)friendsUpdt= new ArrayList<>();
            friendsUpdt.add(amigo.toLowerCase());
            getUser(solicitante).setFriends(friendsUpdt);
            usr=getUser(solicitante);
        }
        for (User u : comunidad) {
            if (u.getUsrName().equalsIgnoreCase(solicitante)){
                comunidad.remove(u);
                comunidad.add(usr);
                System.out.println(usr.getFriends());
                System.out.println(usr);
                break;
            }
        }
        return returneo;
    }

    //Por cada usuario que tenga el mismo nombre, se devuelve en la consulta
    public List<User> consulta(String usuario) {
        return comunidad.stream()
        .filter(User -> User.getUsrName().equals(usuario))
        .collect(Collectors.toList());
    }
}

