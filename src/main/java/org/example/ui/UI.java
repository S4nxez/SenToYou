package org.example.ui;

import org.example.common.Constantes;
import org.example.service.Service;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Scanner;

public class UI {

    public void main() throws IOException, ClassNotFoundException {
        Service serv = new Service();
        Scanner sc = new Scanner(System.in);

        boolean logeao = false;
        String usrname = "";
        int o = 0;

        serv.cargarUsuarios("Usuarios.txt");
        // serv.cargarPaquetes("Paquetes"); hay que meter el método en service

        while (o != 3) {
            // Esto es solo para el user
            System.out.println(Constantes.BIENVENIDA);
            o = sc.nextInt();
            switch (o) {
                case 1:
                    System.out.println("---------------------");
                    System.out.println(Constantes.LOGIN);
                    System.out.println("---------------------");
                    System.out.print(Constantes.USRNAME);
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
                    int mes = sc.nextInt();
                    System.out.print("             " + Constantes.DIA + ": ");
                    int dia = sc.nextInt();
                    LocalDate fechaNac = LocalDate.of(anyo, mes, dia);
                    sc.nextLine();
                    System.out.print(Constantes.USRNAME);
                    usrname = sc.nextLine();
                    System.out.print(Constantes.CONTRASENYA);
                    String pwd = sc.nextLine();
                    serv.register(name, email, direccion, fechaNac, usrname, pwd, false);
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
                        String user = sc.nextLine();
                        serv.setPassword(serv.getUser(user), usrname);
                        break;
                    case 2:
                        serv.listarUsuarios();
                        break;
                    case 3: //Logeao como admin creas un user
                        sc.nextLine();
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
                        if (respuesta.equalsIgnoreCase("y")) {
                            serv.register(name, email, direccion, fechaNac, usrname, pwd, true);
                            System.out.println(Constantes.USERCREADO + "admin" + usrname);
                        } else {
                            serv.register(name, email, direccion, fechaNac, usrname, pwd, false);
                            System.out.println(Constantes.USERCREADO + usrname);
                        }
                        break;
                    case 4:
                        break;
                    case 5:
                        break;
                }
            } else {
                int u = 0;

                while (u != 6) {

                    System.out.println(Constantes.OPCIONESLOGIN);
                    u = sc.nextInt();
                    sc.nextLine();

                    switch (u) {
                        case 1://ENVIAR PAQUETE
                            System.out.println(Constantes.PESO);
                            String input = sc.nextLine();
                            input = input.replace(',', '.');
                            float peso = Float.parseFloat(input);
                            System.out.println(Constantes.RECIPIENT_USRNM);
                            String recipient = sc.nextLine();

                            serv.EnviarPaquete(usrname, recipient, peso);
                            if (serv.getStatus())break; //si que tiene amigos quiere decir esto
                            System.out.println(Constantes.NOAMIGOS);

                        case 2://AÑADIR AMIGOS
                            System.out.println(Constantes.AGREGA_AMIGO);
                            String noAmigo = sc.nextLine();
                            if (!serv.addFriend(usrname, noAmigo)) System.out.println(Constantes.ADDFRIENDERROR);
                            break;
                        case 3: //GESTIONAR PERFIL
                            System.out.println(Constantes.EDITARPERFIL);
                            int e = sc.nextInt();
                            sc.nextLine();
                            switch (e) {
                                case 1:
                                    System.out.print(Constantes.EDITARNOMBRE);
                                    String nombreEdit = sc.nextLine();
                                    serv.setNombre(nombreEdit, serv.getUser(usrname));
                                    break;
                                case 2:
                                    System.out.println(Constantes.EDITARCONTRASENYA);
                                    String pwd = sc.nextLine();
                                    if (serv.login(usrname, pwd)) {
                                        System.out.println(Constantes.ASKNEWPWD);
                                        pwd = sc.nextLine();
                                        serv.setPassword(serv.getUser(usrname), pwd);
                                    }
                                    break;
                                case 3:
                                    System.out.println(Constantes.EDITARUSRNAME);
                                    String nuevoUsrname = sc.nextLine();
                                    serv.setUsrname(nuevoUsrname, usrname);
                                    break;
                            }
                            break;
                        case 4:
                            break;
                        case 5:
                    }
                }
            }
        }
        serv.escribirUsuarios();
        sc.close();
    }
}
