package dev.iesfranciscodelosrios.psp_async_navidad.Services;

import dev.iesfranciscodelosrios.psp_async_navidad.domain.model.Revision;

/**
 * El objetivo de esta clase es calcular la barra de progreso de la revisión.
 * Esto se realizará chequeando todos los pasos de la revisión en cascada para calcular el % por cada requisito revisado.
 */
public class Progress {

    private Revision revision;

    /**
     * Constructor de la clase Progress.
     *
     * @param revision Objeto de revisión que se utilizará para calcular el progreso.
     */
    public Progress(Revision revision) {
        super(); // Llamar al constructor de la clase base (Progress es una extensión de Revision)
        this.revision = revision;
    }

    /**
     * Este método es el método de entrada a la barra de progreso.
     * El método debe verificar si, en primer lugar, todos los atributos del objeto Identificacion de Revision están chequeados.
     * Luego de verificarlo, debe verificar si el Interior se ha completado, etc...
     *
     * (PROBLEMA. Los campos pueden ser true o false y no necesariamente un false significa que no esté chequeado)
     *
     * @return Valor entero que representa el progreso de la revisión.
     */
    public int getProgress() {
        int progress = 0;

        // Verifica si Identificacion está checkeada
        if (isCheckeado(revision.getIdentificacion())) {
            progress += 20; // Ajusta según tu lógica
        }

        // Verifica si Exterior está checkeado
        if (isCheckeado(revision.getExterior())) {
            progress += 20; // Ajusta según tu lógica
        }

        // Verifica si Interior está checkeado
        if (isCheckeado(revision.getInterior())) {
            progress += 20; // Ajusta según tu lógica
        }

        // Verifica si Alineacion está checkeada
        if (isCheckeado(revision.getAlineacion())) {
            progress += 20; // Ajusta según tu lógica
        }

        // Verifica si Emisores está checkeado
        if (isCheckeado(revision.getEmisores())) {
            progress += 20; // Ajusta según tu lógica
        }

        return progress;
    }

    /**
     * Método auxiliar para verificar si un objeto está checkeado.
     *
     * @param obj Objeto a verificar.
     * @return true si el objeto no es nulo y está checkeado, false de lo contrario.
     */
    private boolean isCheckeado(Object obj) {
        return obj != null && obj.isCheckeado();
    }
}
