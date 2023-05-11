package org.example;

import org.example.dao.UserDao;
import org.example.domain.Paquete;
import org.example.domain.User;
import org.example.service.UserService;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;
import org.example.common.*;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {

        Scanner sc = new Scanner(System.in);
        Constantes cos= new Constantes();
        boolean logeao=false;
        boolean salir=false;
        int o = sc.nextInt();
        while(!salir) {
            // Esto es solo para el user
            System.out.println(Constantes.BIENVENIDA);
            switch (o) {
                case 1:
                    System.out.println("---------------------");
                    System.out.println(Constantes.LOGIN);
                    System.out.println("---------------------");
                    System.out.println(Constantes.USRNAME);
                    String usrNameLI = sc.nextLine();
                    System.out.print(Constantes.CONTRASENYA);
                    String pwdLI = sc.nextLine();
                    //Aqui hay que usar primero el find by username y luego pasar al metodo de userservice de login los datos que ha metido para que los compare con los que esten en ese user
                    UserDao.checkLogin(usrNameLI,pwdLI);
                    break;


                case 2:
                    sc.nextLine();
                    System.out.println("---------------------");
                    System.out.println(Constantes.REGISTRO);
                    System.out.println("---------------------");
                    System.out.print(Constantes.NOMBRE);
                    String nombre = sc.nextLine();
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
                    String usrName = sc.nextLine();
                    System.out.print(Constantes.CONTRASENYA);
                    String pwd = sc.nextLine();
                    UserDao userdao = new UserDao();

                     new User(nombre, email, direccion, fechaNac, usrName, pwd);
                    boolean t = false;
                    if (comunidad.size() == 0)
                        comunidad.add(user); //aquí marca error porque no cuenta con que esto se vaya a repetir, habria que hacer el registro y el login metodos de otras clases pero no se de cual.
                    for (int i = 0; i != comunidad.size(); i++) {
                        if (!UserDao.guardar(user, comunidad, i)) t = true;
                    }
                    if (t) System.out.println(Constantes.NODISP);
                    else {
                        comunidad.add(user);
                        UserDao.guardarTxt(user);
                    }
                    break;
                case 3:
                    salir=true;
                    break;
            }

        }
        if(logeao){
            System.out.println("Hola, "+user.getUsrName()+" selecciona una opción:"); //esto no se como ponerlo con constantes con lo del getter
            System.out.println(Constantes.OP1);
            System.out.println(Constantes.OP2);
            System.out.println(Constantes.OP3);
            System.out.println(Constantes.OP4);
            System.out.println(Constantes.OP5);
            System.out.println(Constantes.OP6);
            int u = sc.nextInt();
            switch (u){
                case 1:
                    System.out.println(Constantes.PESO);
                    float pesoLI = sc.nextFloat();
 //                   Paquete paquete= new Paquete(user,);
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
}