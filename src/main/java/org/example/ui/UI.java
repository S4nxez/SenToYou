package org.example.ui;

import org.example.common.Constantes;
import org.example.service.Service;

import java.time.LocalDate;
import java.util.Scanner;

public class UI {
    public UI(){

    }

    public void main(){
        Service serv = new Service();
        Scanner sc = new Scanner(System.in);

        boolean logeao = false;
        String usrname = "";
        int o = 0;

        serv.cargarUsuarios("src//main//Usuarios.txt");

        while (o != 3) {
            // Esto es solo para el user
            System.out.println(Constantes.BIENVENIDA);
            o = sc.nextInt();
            switch (o) {
                case 1:
                    System.out.println("---------------------");
                    System.out.println(Constantes.LOGIN);
                    System.out.println("---------------------");
                    System.out.println(Constantes.USRNAME);
                    sc.nextLine();
                    usrname = sc.nextLine();
                    System.out.print(Constantes.CONTRASENYA);
                    String clave = sc.nextLine();
                    if (serv.login(usrname, clave)) {
                        logeao = true;
                        o = 3;
                    } else
                        System.out.println(Constantes.LOGINFALSE);
                    break;
                case 2:
                    sc.nextLine();
                    System.out.println("---------------------");
                    System.out.println(Constantes.REGISTRO);
                    System.out.println("---------------------");
                    // Recogemos los datos del usuario para registrarle
                    System.out.print(Constantes.NOMBRE);
                    String name = sc.nextLine();
                    System.out.print(Constantes.CORREO);
                    String email = sc.nextLine();
                    System.out.print(Constantes.DIRECCION);
                    String direccion = sc.nextLine();
                    System.out.println(Constantes.FECHA);
                    System.out.print("             " + Constantes.ANYO + ": ");
                    int anyo = sc.nextInt();
                    System.out.print("             " + Constantes.MES + ": ");
                    int mes = sc.nextInt();// mes--; hay clases para las fechas que usan enero para el 0 la que he
                    // puesto creo que no.
                    System.out.print("             " + Constantes.DIA + ": ");
                    int dia = sc.nextInt();
                    LocalDate fechaNac = LocalDate.of(anyo, mes, dia);
                    sc.nextLine();
                    System.out.print(Constantes.USRNAME);
                    usrname = sc.nextLine();
                    System.out.print(Constantes.CONTRASENYA);
                    String pwd = sc.nextLine();
                    serv.register(name, email, direccion, fechaNac, usrname, pwd);
                    break;
                case 3:
                    break;
            }

        }
        if (logeao) {
            System.out.println(Constantes.BIENVENIDALOGIN);
            if (usrname.toLowerCase().startsWith("admin")) { // Si es administrador
                System.out.println(Constantes.LOGINADMIN);// "1.- Cambiar la contraseña de un usuario 2.- Listar todos los usuarios\n
                // 3.- Crear un nuevo usuario 4.- Eliminar un usuario
                int u = sc.nextInt();
                switch (u) {
                    case 1:
                        serv.setPassword(usrname);
                        break;
                    case 2:
                        serv.listarUsuarios();
                        break;
                    case 3:
                        // Recogemos los datos del usuario para registrarle
                        System.out.print(Constantes.NOMBRE);
                        String name = sc.nextLine();
                        System.out.print(Constantes.CORREO);
                        String email = sc.nextLine();
                        System.out.print(Constantes.DIRECCION);
                        String direccion = sc.nextLine();
                        System.out.println(Constantes.FECHA);
                        System.out.print("             " + Constantes.ANYO + ": ");
                        int anyo = sc.nextInt();
                        System.out.print("             " + Constantes.MES + ": ");
                        int mes = sc.nextInt();
                        System.out.print("             " + Constantes.DIA + ": ");
                        int dia = sc.nextInt();
                        LocalDate fechaNac = LocalDate.of(anyo, mes, dia);
                        sc.nextLine();
                        System.out.print(Constantes.USRNAME);
                        usrname = sc.nextLine();
                        System.out.print(Constantes.CONTRASENYA);
                        String pwd = sc.nextLine();
                        System.out.println(Constantes.ADMINONORMAL); // "Quieres que el usuario sea administrador? (y/n)"
                        String respuesta = sc.nextLine();
                        if (respuesta.charAt(1) == 'y' || respuesta.charAt(1) == 'Y') {//el equalsignorecase no funciona
                            serv.crearAdmin(name, email, direccion, fechaNac, usrname, pwd);
                            System.out.println(Constantes.USERCREADO+"admin"+usrname);
                        } else {
                            serv.register(name, email, direccion, fechaNac, usrname, pwd);
                            System.out.println(Constantes.USERCREADO+usrname);
                        }
                        break;
                    case 4:
                        break;
                    case 5:
                        break;

                }
            } else {
                System.out.println(Constantes.OPCIONESLOGIN);
                int u = sc.nextInt();
                switch (u) {
                    case 1:
                        System.out.println(Constantes.PESO);
                        float peso = sc.nextFloat();
                        System.out.println(Constantes.RECIPIENT_USRNM);
                        String recipient = sc.nextLine();

                        serv.EnviarPaquete(user,recipient,peso);
                        break;
                    case 2:
                        break;
                    case 3:
                        break;
                    case 4:
                        break;
                    case 5:
                        break;

                }
            }
        }
        sc.close();

    }
}
