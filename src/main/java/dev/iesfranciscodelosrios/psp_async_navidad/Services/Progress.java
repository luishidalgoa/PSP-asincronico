package dev.iesfranciscodelosrios.psp_async_navidad.Services;

/**
 * El objetivo de esta clase es calcular la barra de progreso de la revision
 * esto lo hara checkeando todos los pasos de la revision en cascada. De modo que de este modo se ira calculando el % por cada
 * requisito revisado.
 */
public class Progress {

    public Progress(){

    }

    /**
     * Este metodo sera el metodo de entrada a la barra de progreso.
     *
     * El metodo debe checkear si en primer lugar todos los atributos del objeto Identificacion de Revision estan checkeados.
     * luego de verficiarlo debe verficiar si el Interior se ha completado, etc...
     *
     * (PROBLEMA. Los campos pueden ser true o false y no necesariamente un false significa que no este chekeado)
     * @return
     */
    public int getProgress(){

    }

    /**
     * NECESITARAS MAS METODOS PARA TRABAJAR. CREA LOS QUE VEAS PERTINENTES
     */
}
