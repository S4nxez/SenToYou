package org.example.service;

import org.example.dao.UserDao;

public class TarifaService { //extends userdao Aqui no se por que hemos puesto que es hijo de UserDao
    private float precioMes;
    private float precioBase;

    private void setPrecioMes(float precioMes){
        this.precioMes= precioMes;
    }
    private void setPrecioBase(float precioBase){ //esto en el diagrama de clases era un boolean por lo que sea y el setPrecioMes de arriba tambien
        this.precioBase=precioBase;
    }
    /*
    private float getShippingPrice(User user){
        return ;
    }*/

}
