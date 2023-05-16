package org.example.dao;

import org.example.domain.Paquete;
import org.example.domain.User;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class PaqueteDao {
    ArrayList<Paquete> paquetes = new ArrayList<>();

    public void enviarPaquete(User emisor, String receptor, float peso) throws IOException {

        Paquete nuevoPaquete = new Paquete(emisor, receptor, peso);
        paquetes.add(nuevoPaquete);
        FileOutputStream fout=new FileOutputStream("Paquetes.txt");
        try (ObjectOutputStream out = new ObjectOutputStream(fout)) {
            out.writeObject(nuevoPaquete.toString());
        }
    }

    //Metodo para guardar los usuarios creados en un fichero antes de cerrar el programa.

    public void enviarPaquete(){

    }
}
