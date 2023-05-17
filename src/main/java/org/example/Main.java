package org.example;
import org.example.ui.UI;
import org.example.common.Constantes;
import org.example.service.Service;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException{
        UI ui = new UI();
        ui.main();
    }
}