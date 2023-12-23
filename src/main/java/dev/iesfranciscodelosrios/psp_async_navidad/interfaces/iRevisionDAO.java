package dev.iesfranciscodelosrios.psp_async_navidad.interfaces;

import dev.iesfranciscodelosrios.psp_async_navidad.domain.model.Coche;
import dev.iesfranciscodelosrios.psp_async_navidad.domain.model.Revision;

public interface iRevisionDAO {
    /**
     * Agraga una revision a la base de datos
     * @param revision Objeto a agregar.
     * @return True si se ha agregado correctamente, false si no.
     */
    public boolean addRevision(Revision revision);

    /**
     * Devuelve la revision a traves del id.
     * @param id id de la revision.
     * @return objeto revision completo.
     */
    public Revision getRevisionById(int id);

    /**
     * Devuelve la revision a traves del coche. (Usando el metodo getCocheByMat de la interfaz iIdentificacionDAO)
     * @param coche Coche que contiene el id de la revision.
     * @return objeto revision completo.
     */
    public Revision getRevisionByCocheMat(Coche coche);
}
