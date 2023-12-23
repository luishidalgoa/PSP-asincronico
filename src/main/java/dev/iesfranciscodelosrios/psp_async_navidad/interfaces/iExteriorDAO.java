package dev.iesfranciscodelosrios.psp_async_navidad.interfaces;

import dev.iesfranciscodelosrios.psp_async_navidad.domain.model.Exterior;
import dev.iesfranciscodelosrios.psp_async_navidad.domain.model.Revision;

public interface iExteriorDAO {
    /**
     * Guarda en la base de datos la relacion entre la revision y el exterior a traves del id de la revision
     * No se puede guardar un objeto exterior si no tiene todos los campos completos
     * @param exterior objeto completo que se va a guardar en la base de datos
     * @return true si se ha guardado correctamente, false si no se ha guardado
     */
    public boolean addExterior(Exterior exterior);

    /**
     * Devuelve el objeto exterior a traves del id del objeto revision
     * @param revision objeto que contiene el id de la revision
     * @return objeto exterior completo
     */
    public Revision getExteriorByRevision(Revision revision);

}
