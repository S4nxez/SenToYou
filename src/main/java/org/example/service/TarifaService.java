package org.example.service;

import org.example.dao.UserDao;

public class TarifaService extends UserDao { // Aqui no se por que hemos puesto que es hijo de UserDao
    private float precioMes;
    private float precioBase;

    private boolean setPrecioMes(float precioMes){
        return ;
    }
    private boolean setPrecioBase(float precioBase){
        return ;
    }
    private float getShippingPrice(User user){
        return ;
    }
}
