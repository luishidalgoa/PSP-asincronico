package dev.iesfranciscodelosrios.psp_async_navidad.Services;

import dev.iesfranciscodelosrios.psp_async_navidad.domain.model.Pista;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class ControlAcceso implements Runnable {

    private static ControlAcceso instance;
    private static final List<Pista> pistas = new ArrayList<>();


    private ControlAcceso(){
        for (int i = 0; i < 3 ; i++) {
            pistas.add(new Pista());
        }
        Thread t = new Thread(this);
        t.start();
    }

    synchronized public Pista getPista(){
        for (Pista pista : pistas) {
            if(pista.getCompletadoPorcentaje() == 0){
                return pista;
            }
        }
        try {
            System.out.println("TOCA ESPERAR ");
            wait();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("SALGO DE ESPERAR ");
        return null;

    }



    public static ControlAcceso getInstance(){
        if(instance == null){
            instance = new ControlAcceso();
        }
        return instance;
    }

    @Override
    public void run() {

        while (true) {
            for (Pista pista : pistas) {
                if(pista.completadoPorcentaje==0){
                    notifyAll();
                }
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
