package org.example;

import org.example.common.Constantes;
import org.example.service.Service;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Service serv = new Service();
        Scanner sc = new Scanner(System.in);

        boolean logeao=false;
        String usrname="";
        int o=0;

        serv.cargarUsuarios("src//main//Usuarios.txt");

        while(o!=3) {
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
                    if(serv.login(usrname,clave)) {
                        logeao = true;
                        o=3;
                    }
                    else
                        System.out.println(Constantes.LOGINFALSE);
                    break;
                case 2:
                    sc.nextLine();
                    System.out.println("---------------------");
                    System.out.println(Constantes.REGISTRO);
                    System.out.println("---------------------");
                    //Recogemos los datos del usuario para registrarle
                    System.out.print(Constantes.NOMBRE);
                    String name = sc.nextLine();
                    System.out.print(Constantes.CORREO);
                    String email = sc.nextLine();
                    System.out.print(Constantes.DIRECCION);
                    String direccion = sc.nextLine();
                    System.out.println(Constantes.FECHA);
                    System.out.print("             "+Constantes.ANYO+": ");
                    int anyo = sc.nextInt();
                    System.out.print("             "+Constantes.MES+": ");
                    int mes = sc.nextInt();//mes--; hay clases para las fechas que usan enero para el 0 la que he puesto creo que no.
                    System.out.print("             "+Constantes.DIA+": ");
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
        if(logeao){
            if (usrname.equalsIgnoreCase("admin")) {
                
            } else {
                System.out.println(Constantes.BIENVENIDALOGIN);
                System.out.println(Constantes.OPCIONESLOGIN);
                int u = sc.nextInt();
                switch (u){
                    case 1:
                        System.out.println(Constantes.PESO);
                        float pesoLI = sc.nextFloat();
                        System.out.println("");
                        //Paquete paquete= new Paquete(user,);
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