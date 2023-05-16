package org.example.dao;

import org.example.common.Constantes;
import org.example.domain.User;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class Userdao {
    //El arraylist de todos los usuarios
    private ArrayList<User> comunidad;
    
    //El constructor de userdao para inicializarlo en el service
    public Userdao(){
        comunidad=new ArrayList<>();
        cargarUsuarios("Usuarios");
    }

    //Metodo que te saca los usuarios desde el archivo de texto y te los mete en la comunidad
    public void cargarUsuarios(String file){
        Scanner scanner = null;
        comunidad = new ArrayList<>();
        try {
            scanner = new Scanner(new File(file));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        while (scanner.hasNextLine()){
            User usuario = new User(scanner.nextLine());
            comunidad.add(usuario);
        }
    }

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
                System.out.println(Constantes.USRNODISP);
            }
            else if (name.startsWith("admin")) {
                respuesta=false;
                System.out.println(Constantes.NOESADMIN);
            }
        }
        if (respuesta) { //Creamos el usuario
            User nuevouser = new User(name, email, dir, fechaNac, usrname, passwd);
            comunidad.add(nuevouser);
            guardarTxt(nuevouser);
        }
    }

    public void cargarUsers() throws FileNotFoundException{
        //saca los usuarios desde el archivo de texto
    }

    //Método que verifica un inicio de sesión.
    public boolean login(String username, String pwd){
        User usuario = getUser(username);
        if (usuario.getUsrName().equals(username) && usuario.getPwd().equals(pwd)){
            return true;
        }
        else return false;
    }

    //Metodo para guardar los usuarios creados en un fichero antes de cerrar el programa.
    public void guardarTxt(User user) throws FileNotFoundException, IOException, ClassNotFoundException{ //esto tampoco deberia ser static
        FileOutputStream fout=new FileOutputStream("src//main//Usuarios.txt");
        try (ObjectOutputStream out = new ObjectOutputStream(fout)) {
            out.writeObject(user.toString());
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