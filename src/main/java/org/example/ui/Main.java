package org.example.ui;

import java.io.IOException;
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