package org.example.domain;

public class Paquete {
    User emisor = new User();
    String paquete_id, estado, nombre_destinatario;
    public void setEstado(String estado){
        if (estado.equals("")){
        }else {
            this.estado="";
        }
    }
}
