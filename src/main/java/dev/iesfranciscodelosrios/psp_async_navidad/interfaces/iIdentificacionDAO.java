package dev.iesfranciscodelosrios.psp_async_navidad.interfaces;

import dev.iesfranciscodelosrios.psp_async_navidad.domain.model.Coche;
import dev.iesfranciscodelosrios.psp_async_navidad.domain.model.Identificacion;
import dev.iesfranciscodelosrios.psp_async_navidad.domain.model.Revision;

public interface iIdentificacionDAO {
    /**
     * Agraga una identificacion a la base de datos con la relacion de la revision incluida.
     * No se puede agregar una identificacion si no tiene todos los campos completos.
     * @param identificacion Identificacion a agregar.
     * @return True si se ha agregado correctamente, false si no.
     */
    public boolean addIdentificacion(Identificacion identificacion);

    /**
     * Devuelve la identificacion a traves del id de la revision.
     * @param revision Revision que contiene el id de la identificacion.
     * @return Identificacion completa.
     */
    public Identificacion getIdentificacionByRevision(Revision revision);

    /**
     * Devuelve la identificacion a traves del coche.
     * @param coche Coche que contiene el id de la identificacion.
     * @return objeto identificacion completo.
     */
    public Revision getIdentificacionByCocheMat(Coche coche);
}
