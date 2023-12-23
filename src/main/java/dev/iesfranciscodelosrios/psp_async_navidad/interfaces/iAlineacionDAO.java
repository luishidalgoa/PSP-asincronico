package dev.iesfranciscodelosrios.psp_async_navidad.interfaces;

import dev.iesfranciscodelosrios.psp_async_navidad.domain.model.Alineacion;
import dev.iesfranciscodelosrios.psp_async_navidad.domain.model.Revision;

public interface iAlineacionDAO {
    /**
     * Devuelve el objeto Alineacion a traves del id de la revision.
     * @param alineacion objeto Alineacion que contiene el id de la Alineacion.
     * @return objeto Alineacion completo.
     */
    public boolean addAlineacion(Alineacion alineacion);

    /**
     * Devuelve el objeto Alineacion a traves del id de la revision.
     * @param revision objeto Revision que contiene el id de la Alineacion.
     * @return objeto Alineacion completo.
     */
    public Alineacion getAlineacionByRevision(Revision revision);
}
