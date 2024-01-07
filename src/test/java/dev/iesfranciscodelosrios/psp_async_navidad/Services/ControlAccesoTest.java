package dev.iesfranciscodelosrios.psp_async_navidad.Services;

import dev.iesfranciscodelosrios.psp_async_navidad.domain.enums.Marca;
import dev.iesfranciscodelosrios.psp_async_navidad.domain.model.Coche;
import dev.iesfranciscodelosrios.psp_async_navidad.domain.model.Pista;

import static org.junit.jupiter.api.Assertions.*;

class ControlAccesoTest {

    @org.junit.jupiter.api.Test
    void getPista() {
        ControlAcceso c=ControlAcceso.getInstance();
        for (int i = 0; i < 5; i++) {
            Coche aux = new Coche(i,"123", Marca.FORD,"fiesta");
            aux.run();
        }
    }
}