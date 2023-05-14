package org.example.service;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;

import org.example.dao.*;
import org.example.domain.User;

public class Service {
    Userdao usrdao= new Userdao();
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

    public void checkLogin(String usuario, String clave) {
        usrdao.checkLogin(usuario, clave);
    }

    public void guardarTxt(User user) throws FileNotFoundException, IOException, ClassNotFoundException {
        usrdao.guardarTxt(user);
    }

}
