package org.example.domain;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.example.service.Service;

public class Paquete implements Serializable {
    private String nombre_destinatario, nombre_emisor;
    private LocalDate fechaEnvio;
    private int paquete_id;
    private float peso;
    private static int paquete_id_cont = 0;
    Service serv = new Service();


    /**
     * Constructor del paquete normal
     * @param UsuarioEmisor El usuario que envía el paquete
     * @param nombre_destinatario El usuario que recibe el paquete
     * @param peso El peso del paquete
     */
    public Paquete(User UsuarioEmisor, String nombre_destinatario, float peso) {
        nombre_emisor = UsuarioEmisor.getUsrName();
        paquete_id_cont++;
        paquete_id= paquete_id_cont;
        fechaEnvio= LocalDate.now();
        this.nombre_destinatario = nombre_destinatario;
        this.peso = peso;
    }

    public Paquete(String linea){
        String[] campos = linea.split(":");
        paquete_id = Integer.parseInt(campos[0]);
        fechaEnvio = LocalDate.parse(campos[1], DateTimeFormatter.ofPattern("yyyy-dd-MM"));
        nombre_destinatario = campos[2];
        peso = Integer.parseInt(campos[3]);
        nombre_destinatario = campos[4];
        nombre_emisor = campos[5];

    }

    public String getNombre_destinatario() {
        return nombre_destinatario;
    }

    public void setNombre_destinatario(String nombre_destinatario) {
        this.nombre_destinatario = nombre_destinatario;
    }

    public LocalDate getFechaEnvio(){
        return fechaEnvio;
    }

    public int getPaquete_id() {
        return paquete_id;
    }

    public float getPeso() {
        return peso;
    }

    public void setPaquete_id(int paquete_id) {
        this.paquete_id = paquete_id;
    }

    public void setPeso(float peso) {
        this.peso = peso;
    }

    /**
     * @return Devuelve los datos de cada paquete, los queremos para almacenarlo en un fichero de texto.
     */
    @Override
    public String toString() {
        return paquete_id+":"+fechaEnvio+":"+nombre_destinatario+":"+peso+":"+nombre_destinatario+":"+nombre_emisor;
    }
}
