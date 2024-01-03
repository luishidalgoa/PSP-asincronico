package dev.iesfranciscodelosrios.psp_async_navidad.Services;

import static org.junit.jupiter.api.Assertions.*;

class ControlAccesoTest {

    @org.junit.jupiter.api.Test
    void getPista() {
        ControlAcceso c=ControlAcceso.getInstance();
        for (int i = 0; i < 5; i++) {
            c.getPista();
        }
    }
}