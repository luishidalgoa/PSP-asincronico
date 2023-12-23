package dev.iesfranciscodelosrios.psp_async_navidad.interfaces;

import dev.iesfranciscodelosrios.psp_async_navidad.domain.model.Emisores;
import dev.iesfranciscodelosrios.psp_async_navidad.domain.model.Revision;

public interface iEmisionesDAO {
    /**
     * Añade el objeto Emisores a la base de datos con la relacion de la revision incluida.
     * no se puede añadir un objeto Emisores si no tiene todos los campos completos.
     * @param emisores objeto Emisores a añadir.
     * @return true si se ha añadido correctamente, false si no.
     */
    public boolean addEmisiones(Emisores emisores);

    /**
     * Devuelve el objeto Emisores a traves del id de la revision.
     * @param revision objeto Revision que contiene el id de la Emisores.
     * @return objeto Emisores completo.
     */
    public Emisores getEmisionesByRevision(Revision revision);
}