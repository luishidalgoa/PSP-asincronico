package dev.iesfranciscodelosrios.psp_async_navidad.interfaces;

import dev.iesfranciscodelosrios.psp_async_navidad.domain.model.Interior;
import dev.iesfranciscodelosrios.psp_async_navidad.domain.model.Revision;

public interface iInteriorDAO {
    /**
     * Añade un objeto Interior a la base de datos con la relacion de la revision incluida. No se puede agregar
     * un objeto interior si no tiene todos los campos completos.
     * @param interior objeto completo Interior a añadir.
     * @return true si se ha añadido correctamente, false si no.
     */
    public boolean addInterior(Interior interior);

    /**
     * Devuelve el objeto Interior a traves del id de la revision.
     * @param revision objeto Revision que contiene el id del Interior.
     * @return objeto Interior completo.
     */
    public Revision getInteriorByRevision(Revision revision);
}
