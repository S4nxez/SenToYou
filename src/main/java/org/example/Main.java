package org.example;

import org.example.domain.User;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ArrayList<User> comunidad = new ArrayList();
        // Esto es solo para el user
        System.out.println("Bienvenido, selecciona una opción:");
        System.out.println("1.Iniciar sesión");
        System.out.println("2.Registrarse");

        int o = sc.nextInt();

        switch (o){
            case 1:
                System.out.println("---------------------");
                System.out.println("Iniciar Sesión");
                System.out.println("---------------------");
                  System.out.print("Nombre de usuario:"); String usrNameLI=sc.nextLine();
                  System.out.print("Contraseña: "); String pwdLI=sc.nextLine();

                break;
            case 2:
                System.out.println("---------------------");
                System.out.println("Registro");
                System.out.println("---------------------");
                  System.out.print("Nombre: ");String nombre= sc.nextLine();
                  System.out.print("Email: ");String email= sc.nextLine();
                  System.out.print("Dirección: ");String direccion=sc.nextLine();
                  System.out.print("Fecha Nacimiento: ");
                  System.out.print("             Año: ");int anyo= sc.nextInt();
                  System.out.print("             Mes: ");int mes= sc.nextInt();//mes--; hay clases para las fechas que usan enero para el 0 la que he puesto creo que no.
                  System.out.print("             Día: ");int dia= sc.nextInt();
                  LocalDate fechaNac= LocalDate.of(anyo,mes,dia);
                  System.out.print("Nombre de usuario: ");String usrName= sc.nextLine();
                  System.out.print("Contraseña: ");String pwd= sc.nextLine();
                User user= new User(nombre,email,direccion,fechaNac,usrName,pwd);
                comunidad.add(user);
                break;
        }
    }
}