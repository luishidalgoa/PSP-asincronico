package dev.iesfranciscodelosrios.psp_async_navidad.Services;

import dev.iesfranciscodelosrios.psp_async_navidad.domain.model.Pista;

import java.util.ArrayList;
import java.util.List;

public class ControlAcceso {

    private static ControlAcceso instance;
    private static final List<Pista> pistas = new ArrayList<>();


    private ControlAcceso(){
        for (int i = 0; i < 3 ; i++) {
            pistas.add(new Pista(i));
        }
    }

    public synchronized Pista getPista() {
        for (Pista pista : pistas) {
            if (pista.getLibre()) {
                pista.ocuparPista();
                return pista;
            }
        }
        try {
            System.out.println("No hay pistas libres, esperando");
            this.wait(); // Esperar si no hay pistas libres
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return getPista(); // Intentar nuevamente después de la espera
    }
    public synchronized void notifyA(){
        this.notify();
    }


    public static ControlAcceso getInstance(){
        if(instance == null){
            instance = new ControlAcceso();
        }
        return instance;
    }
}
