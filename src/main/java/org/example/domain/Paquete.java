package org.example.domain;

public class Paquete {
    User emisor = new User();
    String estado, nombre_destinatario;
    static int paquete_id;//he puesto static que no se si e eso porque quiero que vaya añadiendo uno cada vez que cree un paquete nuevo
    float peso;
    public Paquete(User emisor, String estado, String nombre_destinatario, float peso) {
        this.emisor = emisor;
        paquete_id++;
        this.estado = estado;
        this.nombre_destinatario = nombre_destinatario;
        this.peso = peso;
    }
    private void enviar_paquete(User emisor, String friend_recipient_Usrname, Paquete paquete){

    }
    public void setEstado(String estado){
        if (estado.equals("")){
        }else {
            this.estado="";
        }
    }
}
