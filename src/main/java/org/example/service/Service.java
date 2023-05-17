package org.example.service;

import org.example.dao.PaqueteDao;
import org.example.dao.SentToYouDao;
import org.example.dao.UserDao;
import org.example.domain.User;
import org.example.dao.Admindao;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;

public class Service {
    UserDao usrdao= new UserDao();
    Admindao admin = new Admindao();
    PaqueteDao pqtDao = new PaqueteDao();

    public boolean getStatus(){
        return pqtDao.getStatus();
    }
    public Service() {}

    public boolean guardar(User user, ArrayList<User> comunidad, int i) {
        return usrdao.guardar(user, comunidad, i);
    }

    public void register(String name, String email, String dir, LocalDate fechaNac, String usrname, String passwd) throws IOException, ClassNotFoundException {
        usrdao.register(name, email, dir, fechaNac, usrname, passwd);
    }
    public void EnviarPaquete(String UsuarioEmisor, String destinatario, float peso) throws IOException {
        pqtDao.enviarPaquete(UsuarioEmisor,destinatario,peso);
    }

    public void cargarUsuarios(String file){
        usrdao.cargarUsuarios(file);
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

    public void crearAdmin(String name, String email, String direccion, LocalDate fecha_nac, String username,
            String pwd) throws FileNotFoundException, ClassNotFoundException, IOException {
        admin.crearAdmin(name, email, direccion, fecha_nac, username, pwd);
    }

    public void setPassword(String administrador) {
        admin.setPassword(administrador);
    }

    public void listarUsuarios() {
        admin.listarUsuarios();
    }


    public String listarAmigos(String username) {
        return usrdao.listarAmigos(username);
    }
}
