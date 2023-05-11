package org.example.dao;

import org.example.common.Constantes;
import org.example.domain.User;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.io.ObjectOutputStream;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

public class UserDao {
    private ArrayList<User> comunidad = new ArrayList();

    public UserDao(String name, String email, String direccion, LocalDate fecha_nac, String username, String pwd) {}

    public boolean guardar(User user, ArrayList<User> comunidad, int i){ //aqui esto lo he puesto publico y static y no se si debería
        if(user.getUsrName().equals(comunidad.get(i))) return false;
        else return true;
    }

    public boolean register(String name, String email, String dir, Date fechaNac, String usrname, String passwd){
        return false;
    }

    public boolean sendPackage(Package Package, String nombreReceptor){
        return true;
    }

    public boolean login(String username, String pwd, User usuario){
        if (usuario.getUsrName().equals(username)&&usuario.getPwd().equals(pwd)){
            return true;
        }
        else return false;
    }
    
    public boolean checkLogin(String usrNameLI, String pwdLI){
        boolean respuesta =false;
        
        if (login(usrNameLI, pwdLI, findByUsername(usrNameLI, comunidad))) {
            System.out.println(Constantes.LOGINOK);
            respuesta = true;
        }
        return respuesta;
    }

    //Metodo para guardar los usuarios creados en un fichero antes de cerrar el programa.
    public void guardarTxt(User user) throws FileNotFoundException, IOException, ClassNotFoundException{ //esto tampoco deberia ser static
        FileOutputStream fout=new FileOutputStream("Usuarios.txt");
        try (ObjectOutputStream out = new ObjectOutputStream(fout)) {
            out.writeObject(user);
        }
    }

    public User findByUsername(String username, ArrayList<User> grupo){
        User usReturn = new User();
        for (int i = 0; i < grupo.size(); i++) {
            if (grupo.get(i).getUsrName().equals(username))
                usReturn=grupo.get(i);
        }
        return usReturn;
    }

    private void updateUser(User user){}
}


/*
    ----------Parking--------
    |                       |
    |                       |
    |                       |
    _________________________
 */