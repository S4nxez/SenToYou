package org.example.dao;

import org.example.common.Constantes;
import org.example.domain.Paquete;
import org.example.domain.User;

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
        for (int i = 0; i < comunidad.size(); i++) {
            if (comunidad.get(i).getUsrName().equals(username))
                usReturn=comunidad.get(i);
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
        if (getUser(solicitante).getFriends().size() == 0) System.out.println(Constantes.NOAMIGOS);
        else {
            for (String i : getUser(solicitante).getFriends()) {
                if (i.equalsIgnoreCase(solicitado)) returneo = true;
            }
        }
        return returneo;
    }
}

