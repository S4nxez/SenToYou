package org.example.service;

import org.example.dao.Userdao;
import org.example.domain.User;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;

public class Service {
    Userdao usrdao= new Userdao();
//    Admindao admin = new Admindao();
    public Service() {}

    public boolean guardar(User user, ArrayList<User> comunidad, int i) {
        return usrdao.guardar(user, comunidad, i);
    }

    public void register(String name, String email, String dir, LocalDate fechaNac, String usrname, String passwd) throws IOException, ClassNotFoundException {
        usrdao.register(name, email, dir, fechaNac, usrname, passwd);
    }

    public boolean login(String username, String pwd) {
        return usrdao.login(username, pwd);
    }


    public void guardarTxt(User user) throws FileNotFoundException, IOException, ClassNotFoundException {
        usrdao.guardarTxt(user);
    }

    public User getUser(String username) {
        return usrdao.getUser(username);
    }

    public boolean addFriend(User amigo) {
        return usrdao.addFriend(amigo);
    }

    public boolean removeFriend(User amigo) {
        return usrdao.removeFriend(amigo);
    }

    public ArrayList<User> getComunidad() {
        return usrdao.getComunidad();
    }

//    public void listarUsuarios() {
//        Admindao.listarUsuarios();
    //}
}
