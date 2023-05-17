package org.example.dao;

import org.example.common.Constantes;
import org.example.domain.Paquete;
import org.example.domain.User;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;


public class PaqueteDao {
    ArrayList<Paquete> paquetes = new ArrayList<>();

    public void enviarPaquete(User emisor, User receptor, float peso) throws IOException {
        if (emisor.esAmigo(receptor)) {
            Paquete nuevoPaquete = new Paquete(emisor, receptor.getUsrName(), peso);
            paquetes.add(nuevoPaquete);
            FileOutputStream fout = new FileOutputStream("Paquetes.txt");
            try (ObjectOutputStream out = new ObjectOutputStream(fout)) {
                out.writeObject(nuevoPaquete.toString());
            }
        }
        else System.out.println(Constantes.NOAMIGO);
    }
    //Metodo para guardar los usuarios creados en un fichero antes de cerrar el programa.

}
