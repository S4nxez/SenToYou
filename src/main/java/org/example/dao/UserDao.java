package org.example.dao;

import org.example.common.Constantes;
import org.example.domain.User;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.io.ObjectOutputStream;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Userdao {
    //El arraylist de todos los usuarios
    private ArrayList<User> comunidad = new ArrayList<>();
    
    //El constructor de userdao para inicializarlo en el service
    public Userdao(){}
    /*???????????????????*/public Userdao(String name, String email, String direccion, LocalDate fecha_nac, String username, String pwd) {}
    
    //Método que te devuelve un usuario a partir de su nombre
    public User getUser(String username){
        User usReturn = new User();
        for (int i = 0; i < comunidad.size(); i++) {
            if (comunidad.get(i).getUsrName().equals(username))
                usReturn=comunidad.get(i);
        }
        return usReturn;
    }
    
    //Método que recibe un usuario y comprueba si está en el sistema.
    public boolean guardar(User user, ArrayList<User> comunidad, int i){
        if(user.getUsrName().equals(comunidad.get(i).getUsrName())) return false;
        else return true;
    }

    //Método que registra un nuevo usuario en el sistema
    public void register(String name, String email, String dir, LocalDate fechaNac, String usrname, String passwd) throws FileNotFoundException, ClassNotFoundException, IOException{
        boolean respuesta=true ;
        for (int j = 0; j < comunidad.size(); j++) {
            //Verificamos que el usuario no esté ya creado
            if (name.equals(comunidad.get(j).getUsrName()) || email.equals(comunidad.get(j).getEmail())){
                respuesta=false;
                System.out.println(Constantes.USRNODISP);}
        }
        if (respuesta) { //Creamos el usuario
            User nuevouser = new User(name, email, dir, fechaNac, usrname, passwd);
            comunidad.add(nuevouser);
            guardarTxt(nuevouser);
        }
    }

    //Método que verifica un inicio de sesión.
    public boolean login(String username, String pwd){
        User usuario = getUser(username);
        if (usuario.getUsrName().equals(username) && usuario.getPwd().equals(pwd)){
            return true;
        }
        else return false;
    }

    //Método que responde si el inicio de sesión es correcto o no.
    public void checkLogin(String usuario, String clave){
        if (login(usuario, clave)) {
            System.out.println(Constantes.LOGINOK);
        }
        else
            System.out.println(Constantes.LOGINFALSE);
    }

    //Metodo para guardar los usuarios creados en un fichero antes de cerrar el programa.
    public void guardarTxt(User user) throws FileNotFoundException, IOException, ClassNotFoundException{ //esto tampoco deberia ser static
        FileOutputStream fout=new FileOutputStream("Usuarios.txt");
        try (ObjectOutputStream out = new ObjectOutputStream(fout)) {
            out.writeObject(user);
        }
    }

    //private void updateUser(User user){}

    public boolean addFriend(User amigo){
        return true;
    }
    
    public boolean removeFriend(User amigo){
        return true;
    }

    public ArrayList<User> getComunidad() {
        return comunidad;
    }

}


/*
    ----------Parking--------
    |                       |
    |                       |
    |                       |
    _________________________
 */