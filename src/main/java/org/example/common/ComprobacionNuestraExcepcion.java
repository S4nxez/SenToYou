package org.example.common;

import java.util.List;

import org.example.domain.User;

public class ComprobacionNuestraExcepcion {
    public static void compuebaExcepcion(String usuario, List<User> comunidad) throws NuestraExcepcion {
        for (User u : comunidad) {
            if (u.getUsrName().equals(usuario)) {
                throw new NuestraExcepcion("El usuario " + usuario + " ya existe en la comunidad");
            }
        }
    }
    
}
