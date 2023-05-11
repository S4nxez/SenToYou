package org.example.domain;

public class Paquete {
    String estado, nombre_destinatario;
    static int paquete_id;//he puesto static que no se si es eso porque quiero que vaya añadiendo uno cada vez que cree un paquete nuevo
    float peso;

    public Paquete(User UsuarioEmisor, String estado, String nombre_destinatario, float peso) {
        User emisor = UsuarioEmisor;
        paquete_id++;
        this.estado = estado;
        this.nombre_destinatario = nombre_destinatario;
        this.peso = peso;
    }


    private String getEstadoPaquete(String paquete_id){
        return "";
    }

    public void setEstadoPaquete(String estado){
        this.estado=estado;
    }
}
