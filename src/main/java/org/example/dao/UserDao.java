package org.example.dao;

import org.example.common.ComprobacionNuestraExcepcion;
import org.example.common.Constantes;
import org.example.common.NuestraExcepcion;
import org.example.domain.User;
import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserDao extends SentToYouDao {

    public void cargarUsuarios(String file) {
        Scanner scanner = null;
        comunidad = new ArrayList<>();
        try {
            scanner = new Scanner(new File(file));
            while (scanner.hasNextLine()) {
                User usuario = new User(scanner.nextLine());
                comunidad.add(usuario);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Archivo no encontrado");
        }
    }//ARCHIVOS NO BINARIOS, READ
    public void escribirUsuarios(String file){
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

    public void cargarUsers() throws FileNotFoundException {
    }

    // Método que verifica un inicio de sesión.
    public boolean login(String username, String pwd) {
        User usuario = getUser(username);
        if (usuario.getUsrName().equals(username) && usuario.getPwd().equals(pwd)) {
            return true;
        } else return false;
    }

    // Metodo para guardar los usuarios creados en un fichero antes de cerrar el
    // programa.
    public void guardarTxt(User user) throws FileNotFoundException, IOException {
        try {
            FileOutputStream fout = new FileOutputStream("UsuariosBinario.txt", true);
            ObjectOutputStream out = new ObjectOutputStream(fout);
            out.writeObject(user.toString());
            out.close();

        } catch (FileNotFoundException e) {
            System.out.println("Archivo no encontrado, creando uno nuevo");
            File file = new File("UsuariosBinario.txt");
            guardarTxt(user);
        }
    }

    //private void updateUser(User user){}




    public boolean removeFriend(User amigo) {
        return true;
    }

    public List<User> getComunidad() {
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