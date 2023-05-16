package org.example.dao;

import org.example.common.Constantes;
import org.example.domain.User;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Scanner;

public class Admindao {

    public Admindao() {}
    Userdao usr = new Userdao();

    //Crear un nuevo usuario administrador en el sistema
    public void crearAdmin(String name, String email, String direccion, LocalDate fecha_nac, String username,
            String pwd) throws FileNotFoundException, ClassNotFoundException, IOException {
        boolean respuesta = true;
        for (int j = 0; j < usr.getComunidad().size(); j++) {
            // Verificamos que el admin no esté ya creado
            if ("admin" + name == usr.getComunidad().get(j).getUsrName()) {
                respuesta = false;
                System.out.println(Constantes.USRNODISP);
            }
        }
        if (respuesta) { // Creamos el usuario
            User nuevouser = new User(name, email, direccion, fecha_nac, "admin" + username, pwd);
            usr.getComunidad().add(nuevouser);
            usr.guardarTxt(nuevouser);
        }
    }

    /**
     * Metodo para cambiar la contraseña de cualquier usuario excepto administradores (la tuya propia si puedes)
     * @param administrador Parametro que recoge el nombre de usuario del administrador que realiza la peticion de cambio de la clave.
     */
    public void setPassword(String administrador) {
        final Scanner sc = new Scanner(System.in);
        System.out.println(Constantes.SETPWDNOMBRE);//"Por favor, introduzca el nombre del usuario al que quieras cambiarle la contraseña"
        String victima = sc.nextLine();
        if (victima.startsWith("admin") && victima!=administrador) {
            System.out.println(Constantes.ERRORPWDADMIN); //"Error, no puedes cambiarle la contraseña a un administrador diferente"
        } else {
            Boolean salir = false;
            while (!salir) {
                System.out.println(Constantes.ASKNEWPWD);
                String newpwd = sc.nextLine();
                System.out.println(Constantes.CONFIRMPWD);
                String pwdconfirmacion = sc.nextLine();
                if (newpwd.equals(pwdconfirmacion)) {
                    usr.getUser(victima).setPwd(newpwd);
                    System.out.println(Constantes.PWDCHANGED);
                    !salir;
                }
            }
        }
    }

    //Decir todos los usuarios que existen en comunidad
    public void listarUsuarios() {
        usr.getComunidad().forEach(User -> System.out.println(User));
        /*
         * Seria lo mismo que esto
         * for (User usuario : srv.getComunidad()) {
         * System.out.println(usuario);
         * }
         */
    }

    private boolean cambiaPrecio(float precio) {
        return true;
    }

    private boolean addUser(User usuario) {
        return true;
    }

    private boolean borrarUser(User usuario) {
        return true;
    }
}
