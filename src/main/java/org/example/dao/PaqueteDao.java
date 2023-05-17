package org.example.dao;

import org.example.common.Constantes;
import org.example.domain.Paquete;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class PaqueteDao extends SentToYouDao{
    private boolean status=false;
    public void enviarPaquete(String nombreemisor, String nombrereceptor, float peso) throws IOException {
        if (esAmigo(nombreemisor, nombrereceptor)) {
            Paquete nuevoPaquete = new Paquete(nombreemisor, nombrereceptor, peso);
            paquetes.add(nuevoPaquete);
            FileOutputStream fout = new FileOutputStream("Paquetes.txt");
            try (ObjectOutputStream out = new ObjectOutputStream(fout)) {
                out.writeObject(nuevoPaquete.toString());
                setStatus(true);
            }//ARCHIVOS BINARIOS
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