package org.example.dao;

import org.example.domain.User;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.io.ObjectOutputStream;

import java.time.LocalDate;
import java.util.ArrayList;

public class UserDao extends User {
    ArrayList<User> Users = new ArrayList();

    public UserDao(String name, String email, String direccion, LocalDate fecha_nac, String username, String pwd) {
        super(name, email, direccion, fecha_nac, username, pwd);
    }

    public static boolean guardar(User user, ArrayList<User> comunidad, int i){ //aqui esto lo he puesto publico y static y no se si debería
        if(user.getUsrName().equals(comunidad.get(i))) return false;
        else return true;
    }
    /*private User findByUserName(String userName){
        return ;
    }*/


    //Metodo para guardar los usuarios creados en un fichero antes de cerrar el programa.
    public static void guardarTxt(User user) throws FileNotFoundException, IOException, ClassNotFoundException{ //esto tampoco deberia ser static
        FileOutputStream fout=new FileOutputStream("Usuarios.txt");
        try (ObjectOutputStream out = new ObjectOutputStream(fout)) {
            out.writeObject(user);
        }
    }
}