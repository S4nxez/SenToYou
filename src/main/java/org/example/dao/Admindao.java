//package org.example.dao;
//import org.example.domain.User;
//import org.example.service.Service;
//
//import java.io.FileNotFoundException;
//import java.io.IOException;
//import java.time.LocalDate;
//
//public class Admindao {
//
//    public Admindao(String name, String email, String direccion, LocalDate fecha_nac, String username, String pwd) throws FileNotFoundException, ClassNotFoundException, IOException {
//        Service.register(name, email, direccion, fecha_nac, username, pwd);
//    }
//    public Admindao(){}
//
//    public void listarUsuarios() {
//        Service.getComunidad().forEach(User -> System.out.println(User));
//        /*Seria lo mismo que esto
//        for (User usuario : srv.getComunidad()) {
//            System.out.println(usuario);
//        }*/
//    }
//    // private boolean cambiaPrecio(float precio){
//    //     return true;
//    // }
//
//    // private boolean addUser(User usuario){
//    //     return true;
//    // }
//
//    // private boolean borrarUser(User usuario){
//    //     return true;
//    // }
//}
