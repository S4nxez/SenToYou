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
    private boolean status=false;
    public PaqueteDao(){} //constructor vacio para llamarlo desde service

    public void enviarPaquete(User emisor, User receptor, float peso) throws IOException {
        if (emisor.esAmigo(receptor)) {
            Paquete nuevoPaquete = new Paquete(emisor, receptor.getUsrName(), peso);
            paquetes.add(nuevoPaquete);
            FileOutputStream fout = new FileOutputStream("Paquetes.txt");
            try (ObjectOutputStream out = new ObjectOutputStream(fout)) {
                out.writeObject(nuevoPaquete.toString());
                setStatus(true);
            }
        }
        else {
            System.out.println(Constantes.NOAMIGO);
            setStatus(false);
        }
    }

    private void setStatus(Boolean status){
        this.status=status;
    }

    public boolean getSatus(){
        return status;
    }
    //Metodo para guardar los usuarios creados en un fichero antes de cerrar el programa.

}