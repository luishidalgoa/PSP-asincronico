package dev.iesfranciscodelosrios.psp_async_navidad.Services;

import dev.iesfranciscodelosrios.psp_async_navidad.domain.model.Revision;

/**
 * Este
 */
public class Simulacion {
    private static Simulacion _instance;

    private Simulacion(){

    }

    /**
     *
     * @param revision
     */
    public void startSimulacion(Revision revision){

    }

    public static Simulacion getInstance(){
        if(_instance == null){
            _instance = new Simulacion();
        }
        return _instance;
    }
}
