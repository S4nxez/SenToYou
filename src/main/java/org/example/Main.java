package org.example;

import org.example.dao.UserDao;
import org.example.domain.User;
import org.example.service.UserService;

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

                //Aqui hay que usar primero el find by username y luego pasar al metodo de userservice de login los datos que ha metido para que los compare con los que esten en ese user
                if (UserService.login(usrNameLI,pwdLI, UserService.findByUsername(usrNameLI,comunidad))){
                    System.out.println("Login correcto");
                }
                break;

                
            case 2:
                sc.nextLine();
                System.out.println("---------------------");
                System.out.println("Registro");
                System.out.println("---------------------");
                  System.out.print("Nombre: ");String nombre= sc.nextLine();
                  System.out.print("Email: ");String email= sc.nextLine();
                  System.out.print("Dirección: ");String direccion=sc.nextLine();
                  System.out.println("Fecha Nacimiento: ");
                  System.out.print("             Año: ");int anyo= sc.nextInt();
                  System.out.print("             Mes: ");int mes= sc.nextInt();//mes--; hay clases para las fechas que usan enero para el 0 la que he puesto creo que no.
                  System.out.print("             Día: ");int dia= sc.nextInt();
                  LocalDate fechaNac= LocalDate.of(anyo,mes,dia);
                  sc.nextLine();
                  System.out.print("Nombre de usuario: ");String usrName= sc.nextLine();
                  System.out.print("Contraseña: ");String pwd= sc.nextLine();
                User user= new User(nombre,email,direccion,fechaNac,usrName,pwd);
                boolean t = false;
                if (comunidad.size()==0)comunidad.add(user); //aquí marca error porque no cuenta con que esto se vaya a repetir, habria que hacer el registro y el login metodos de otras clases pero no se de cual.
                for (int i = 0; i != comunidad.size(); i++) {
                    if(!UserDao.guardar(user,comunidad,i))t=true;
                }
                if(t) System.out.println("Username no disponible");
                else comunidad.add(user);
                break;
        }
    }
}