package org.example.domain;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.example.service.Service;

public class Paquete implements Serializable {
    private String estado, nombre_destinatario, nombre_emisor;
    private int paquete_id;
    private float peso;
    Service serv = new Service();


    public Paquete(User UsuarioEmisor, String nombre_destinatario, float peso, String estado, int paquete_id) {
        nombre_emisor = UsuarioEmisor.getUsrName();
        this.paquete_id= paquete_id;
        this.estado = estado;
        this.nombre_destinatario = nombre_destinatario;
        this.peso = peso;
    }
    public Paquete(String linea){
        String[] campos = linea.split(":");
        paquete_id = Integer.parseInt(campos[0]);
        estado = campos[1];
        nombre_destinatario = campos[2];
        peso = Integer.parseInt(campos[3]);
        nombre_destinatario = campos[4];
        nombre_emisor = campos[5];
        //fecha_envio = LocalDate.parse(campos[4], DateTimeFormatter.ofPattern("yyyy-dd-MM"));
    }
    @Override
    public String toString() {
        return paquete_id+":"+estado+":"+nombre_destinatario+":"+peso+":"+nombre_destinatario+":"+nombre_emisor+":"++":";
    }

    public String getNombre_destinatario() {
        return nombre_destinatario;
    }

    public void setNombre_destinatario(String nombre_destinatario) {
        this.nombre_destinatario = nombre_destinatario;
    }

    public String getEstado(){
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
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
}
