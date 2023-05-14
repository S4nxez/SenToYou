package org.example.domain;

import java.io.Serializable;

import org.example.service.Service;

public class Paquete implements Serializable {
    private String estado, nombre_destinatario;
    private int paquete_id;
    private float peso;
    Service serv = new Service();

    public Paquete(User UsuarioEmisor, String nombre_destinatario, float peso, String estado, int paquete_id) {
        nombre_destinatario = UsuarioEmisor.getUsrName();
        this.paquete_id= paquete_id;
        this.estado = estado;
        this.nombre_destinatario = nombre_destinatario;
        this.peso = peso;
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
