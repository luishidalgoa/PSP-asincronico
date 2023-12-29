package dev.iesfranciscodelosrios.psp_async_navidad.Services;

import dev.iesfranciscodelosrios.psp_async_navidad.domain.model.Pista;

import java.util.ArrayList;
import java.util.List;

public class ControlAcceso {

    private static ControlAcceso instance;
    private static final List<Pista> pistas = new ArrayList<>();

    private ControlAcceso(){
        for (int i = 0; i < 3 ; i++) {
            pistas.add(new Pista());
        }
    }

    synchronized public Pista getPista(){
        return null;
    }

    public static ControlAcceso getInstance(){
        if(instance == null){
            instance = new ControlAcceso();
        }
        return instance;
    }
}
