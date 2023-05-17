package org.example;
import org.example.ui.UI;
import org.example.common.Constantes;
import org.example.service.Service;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws NullPointerException, IOException, ClassNotFoundException {
        UI ui = new UI();
        ui.main();
    }
//    public static void main(String[] args){
//        UI ui = new UI();
//        try {
//            ui.main();
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        } catch (ClassNotFoundException e) {
//            throw new RuntimeException(e);
//        }
//    }
}