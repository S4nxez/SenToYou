package org.example.dao;

import org.example.domain.Paquete;
import org.example.domain.User;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class PaqueteDao {
    ArrayList<Paquete> paquetes = new ArrayList<Paquete>();
    int codigo=0;
    public void enviar_paquete(User emisor, String receptor, float peso){  
        codigo++;
        Paquete nuevoPaquete = new Paquete(emisor, receptor, peso, "", codigo);
        paquetes.add(nuevoPaquete);
    }

    //Metodo para guardar los usuarios creados en un fichero antes de cerrar el programa.
    public void guardarPaquete(Paquete paquete) throws FileNotFoundException, IOException, ClassNotFoundException{ //esto tampoco deberia ser static
        FileOutputStream fout=new FileOutputStream("Paquetes.txt");
        try (ObjectOutputStream out = new ObjectOutputStream(fout)) {
            out.writeObject(paquete);
        }
    }
}
