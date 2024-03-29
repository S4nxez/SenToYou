package org.example.dao;

import org.example.domain.Paquete;
import org.example.domain.User;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class SentToYouDao {
    protected List<Paquete> paquetes;
    protected List<User> comunidad = new ArrayList<>();

    public SentToYouDao() {
        paquetes = new ArrayList<>();
    }

    public User getUser(String username) {
        User usReturn = new User(null, null, null, null, null, null);
        for (User user : comunidad) {
            if (user.getUsrName().equals(username))
                usReturn = user;
        }
        return usReturn;
    }

    public String listarAmigos(String username) {
        StringBuilder respuesta = new StringBuilder();
        /*
        for (int i = 0; i < getUser(username).getFriends().size(); i++) {
            respuesta.append(getUser(username).getFriends().get(i)).append(",");
        }*/
        for (String u : getUser(username).getFriends()) {
            respuesta.append(u).append(",");
        }
        return respuesta.toString();
    }

    public boolean esAmigo(String solicitante, String solicitado) {
        boolean returneo = false;

        for (String i : getUser(solicitante).getFriends()) {
            if (i.equalsIgnoreCase(solicitado)) {
                returneo = true;
                break;
            }
        }

        return returneo;
    }

    public boolean addFriend(String solicitante, String amigo) {
        User usr = getUser(solicitante);
        boolean returneo = esAmigo(solicitante, amigo) || (getUser(amigo).getUsrName() == null);
        if (!returneo) {
            getUser(solicitante).setFriends(amigo);
            usr = getUser(solicitante);
            returneo = true;
        } else returneo = false;
        Iterator<User> iterator = comunidad.iterator();
        while (iterator.hasNext()) {
            User u = iterator.next();
            if (u.getUsrName().equalsIgnoreCase(solicitante)) {
                iterator.remove();
                comunidad.add(usr);
                System.out.println(usr.getFriends());
                System.out.println(usr);
                break;
            }
        }
        return returneo;
    }

    //Por cada usuario que tenga el mismo nombre, se devuelve en la consulta
    public List<User> consulta(String name) {
        return comunidad.stream()
                .filter(User -> User.getName().equals(name))
                .collect(Collectors.toList());
    }
}

