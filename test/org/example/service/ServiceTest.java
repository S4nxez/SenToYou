package org.example.service;

import org.example.domain.User;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class ServiceTest {



    @Nested
    class PruebasCreandoUsuarios{
        String user = "paco";
        Service srv = new Service();
        User esperato = new User(null,null,null,null,null,null);
        @Test
        @DisplayName("Dado un String de usuario devuelve un Objeto del usuario entero")
        void getUser() {
            String user = "paco";
            Service srv = new Service();
            User resultado = srv.getUser(user);
            assertEquals(resultado.toString(),esperato.toString(), "El usuario esperado no es nulo");
        }
        @Test
        @DisplayName("Dado un String de usuario devuelve un Objeto del usuario entero")
        void getUser2() {
            User resultado = srv.getUser(user);
            assertThat(resultado).isIn(srv.getComunidad());
        }
    }
}