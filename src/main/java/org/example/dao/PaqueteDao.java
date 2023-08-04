package org.example.dao;

import org.example.common.Constantes;
import org.example.domain.Paquete;
import org.example.domain.User;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class PaqueteDao extends SentToYouDao{
    private boolean status=false;

//    public cargarPaquetes(){//tenemos que hacer que el metodo sea como el cargarusuarios del userdao pero que lo haga en un binario y no en un txt

//    }

    public void enviarPaquete(String nombreemisor, String nombrereceptor, float peso) throws IOException {
        if (esAmigo(nombreemisor, nombrereceptor)) {
            Paquete nuevoPaquete = new Paquete(nombreemisor, nombrereceptor, peso);
            paquetes.add(nuevoPaquete);
            FileOutputStream fout = new FileOutputStream("Paquetes.txt");
            try (ObjectOutputStream out = new ObjectOutputStream(fout)) {
                out.writeObject(nuevoPaquete.toString());
                setStatus(true);
            }//ARCHIVOS BINARIOS, WRITE
        }
        else {
            System.out.println(Constantes.NOAMIGO);
            setStatus(false);
        }
    }

    private void setStatus(Boolean status){
        this.status=status;
    }

    public boolean getStatus(){
        return status;
    }
    //Metodo para guardar los usuarios creados en un fichero antes de cerrar el programa.

}