package dev.iesfranciscodelosrios.psp_async_navidad.domain.model;

public class Identificacion {
    private Revision revision;
    private Coche coche;

    public Identificacion(Revision revision, Coche coche) {
        this.revision = revision;
        this.coche = coche;
    }

    public Identificacion() {
    }

    public Revision getRevision() {
        return revision;
    }

    public void setRevision(Revision revision) {
        this.revision = revision;
    }

    public Coche getCoche() {
        return coche;
    }

    public void setCoche(Coche coche) {
        this.coche = coche;
    }
}
