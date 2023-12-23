package dev.iesfranciscodelosrios.psp_async_navidad.interfaces;

import dev.iesfranciscodelosrios.psp_async_navidad.domain.model.Coche;

public interface iCocheDAO {
    /**
     * Devuelve el coche a traves de la matricula.
     * @param matricula Matricula del coche.
     * @return objeto coche completo.
     */
    public Coche getCocheByMat(String matricula);

    /**
     * Devuelve el coche a traves del id.
     * @param id id del coche.
     * @return objeto coche completo.
     */
    public Coche getCocheById(int id);

    /**
     * Añade un coche completo a la base de datos.
     * @param coche objeto coche a añadir.
     * @return true si se ha añadido correctamente, false si no.
     */
    public boolean addCoche(Coche coche);

}
