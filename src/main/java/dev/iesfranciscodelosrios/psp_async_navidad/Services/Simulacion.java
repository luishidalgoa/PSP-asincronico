package dev.iesfranciscodelosrios.psp_async_navidad.Services;

import dev.iesfranciscodelosrios.psp_async_navidad.domain.model.*;

/**
 * Este
 */
public class Simulacion {
    private static Simulacion _instance;

    int SleepMS=500;

    private Simulacion(){

    }

    /**
     * Este metodo hara la simulacion de la revision completa.
     * es decir que ejecutara primero el metodo Identificacion(), luego Interior(), etc.
     *
     * cuando la simulacion de la revision finalice. Se guardaran los datos en la bbdd a traves de los DAOS
     * @param revision
     */
    public void startSimulacion(Revision revision){

    }

    /**
     * Este metodo hara la identificacion de la revision del vehiculo. Es decir checkeara los atributos de la clase Identificacion
     *
     * (PORFAVOR METEDLE UN SLEEP AL HILO DE 500ms para simular el progreso. usad la variable SleepMS)
     */
    private void Identificacion(Identificacion identificacion){

    }

    /**
     *  Este metodo hara el test de todos los atributos de la clase Interior.
     *
     *  (PORFAVOR METEDLE UN SLEEP AL HILO DE 500ms para simular el progreso. usad la variable SleepMS)
     */
    private void Interior(Interior interior){

    }

    /**
     *  Este metodo hara el test de todos los atributos de la clase Exterior.
     *
     *  (PORFAVOR METEDLE UN SLEEP AL HILO DE 500ms para simular el progreso. usad la variable SleepMS)
     * @param exterior
     */
    private void Exterior(Exterior exterior){

    }

    /**
     *  Este metodo hara el test de todos los atributos de la clase Alineacion.
     *
     *  (PORFAVOR METEDLE UN SLEEP AL HILO DE 500ms para simular el progreso. usad la variable SleepMS)
     * @param alineacion
     */
    private void Alineacion(Alineacion alineacion){

    }

    /**
     *  Este metodo hara el test de todos los atributos de la clase Emisores.*
     *
     *  (PORFAVOR METEDLE UN SLEEP AL HILO DE 500ms para simular el progreso. usad la variable SleepMS)
     * @param emisores
     */
    private void Emisores(Emisores emisores){

    }

    public static Simulacion getInstance(){
        if(_instance == null){
            _instance = new Simulacion();
        }
        return _instance;
    }
}
