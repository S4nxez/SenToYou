package org.example.dao;

import org.example.common.Constantes;
import org.example.domain.User;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserDao extends SentToYouDao {

    public void cargarUsuarios(String file) {
        Scanner scanner;
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

    public void escribirUsuarios(String file) {
        Scanner scanner;
        comunidad = new ArrayList<>();
        try {
            scanner = new Scanner(new File(file));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        while (scanner.hasNextLine()) {
            User usuario = new User(scanner.nextLine());
            comunidad.add(usuario);
        }
    }

    //Método que recibe un usuario y comprueba si está en el sistema.
    public boolean guardar(User user, ArrayList<User> comunidad, int i) {
        return !user.getUsrName().equals(comunidad.get(i).getUsrName());
    }

    //Método que registra un nuevo usuario en el sistema
    public void register(String name, String email, String dir, LocalDate fechaNac, String usrname, String passwd, boolean admin) throws IOException {
        if(admin)usrname= "admin"+usrname;
        boolean respuesta = nombreDisponible(usrname);
        for (User user : comunidad) {
            //Verificamos que el usuario no esté ya creado
            if (email.equals(user.getEmail())) {
                respuesta = false;
                break;
            }
        }
        if (respuesta) { //Creamos el usuario
            User nuevoUser = new User(name, email, dir, fechaNac, usrname, passwd);
            comunidad.add(nuevoUser);
            guardarTxt(false);
        }else{
            System.out.println(Constantes.USRNODISP);
        }
    }

    public boolean nombreDisponible(String usrname) {
        boolean returneo = true;
        for (User user : comunidad) {
            if (usrname.equals(user.getUsrName())) {
                returneo = false;
                System.out.println(Constantes.USRNODISP);
            }
        }
        return returneo;
    }

    // Método que verifica un inicio de sesión.
    public boolean login(String username, String pwd) {
        try {
            User usuario = getUser(username);

            return usuario.getUsrName().equals(username) && usuario.getPwd().equals(pwd);
        } catch (NullPointerException e) {
            return false;
        }
    }

    public void guardarTxt(boolean append) throws IOException { //habrá problemas con el parámetro de entrada append, debería añadir algún if para diferenciar de cuando solo quiero meter un user más y no toda la lista appendada
        try {
            FileWriter fout = new FileWriter("Usuarios.txt", append);
            BufferedWriter out = new BufferedWriter(fout);
            int i = 0;
            for (User u : comunidad) {
                i++;
                out.write(u.toString());
                if (u.getFriends().equals("BUG"))
                    out.write("BUG,");
                if (i < comunidad.size()) out.newLine();
            }
            out.close();
        } catch (FileNotFoundException e) {
            System.out.println("Archivo no encontrado, creando uno nuevo");
            guardarTxt(true);
        }
    }

    public boolean removeFriend(User amigo) {
        return true;
    }

    public List<User> getComunidad() {
        return comunidad;
    }

    public void setUsrnm(String nuevoUsrname, String viejoUsrnm) {
        getUser(viejoUsrnm).setUsrname(nuevoUsrname);
    }
}


/*
    ----------Parking--------
    |                       |
    |                       |
    |                       |
    _________________________
 */