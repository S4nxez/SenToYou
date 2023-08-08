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
    public void escribirUsuarios(String file){
        Scanner scanner;
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
            if (usrname.equals(comunidad.get(j).getUsrName()) || email.equals(comunidad.get(j).getEmail())){
                respuesta=false;
                System.out.println(Constantes.USRNODISP);}
        }
        if (respuesta) { //Creamos el usuario
            User nuevouser = new User(name, email, dir, fechaNac, usrname, passwd);
            comunidad.add(nuevouser);
            guardarTxt(true);
        }
    }

    public void cargarUsers() throws FileNotFoundException {
    }

    // Método que verifica un inicio de sesión.
    public boolean login(String username, String pwd) {
        try {
            User usuario = getUser(username);

            if (usuario.getUsrName().equals(username) && usuario.getPwd().equals(pwd)) {
                return true;
            } else return false;
        }catch (NullPointerException e){
            return false;
        }
    }

    public void guardarTxt(boolean append) throws IOException { //habrá problemas con el parametro de entrada append, debería añadir algun if para diferenciar de cuando solo quiero meter un user mas y no toda la lista appendada
        try {
            FileWriter fout = new FileWriter("Usuarios.txt", append);
            BufferedWriter out = new BufferedWriter(fout);
            int i=0;
            for (User u: comunidad) {
                i++;
                out.write(u.toString());
                if(u.getFriends().equals("BUG"))
                    out.write("BUG,");
                if (i < comunidad.size())out.newLine();
            }
            out.close();
        } catch (FileNotFoundException e) {
            System.out.println("Archivo no encontrado, creando uno nuevo");
            File file = new File("Usuarios.txt");
            guardarTxt(true);
        }
    }

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