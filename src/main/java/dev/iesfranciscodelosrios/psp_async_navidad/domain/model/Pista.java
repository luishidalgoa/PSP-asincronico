package dev.iesfranciscodelosrios.psp_async_navidad.domain.model;

public class Pista {
    public int completadoPorcentaje;
    private Revision revision;

    public Pista() {
        completadoPorcentaje = 0;
    }

    public Pista(Revision revision) {
        this.revision = revision;
        completadoPorcentaje = 0;
    }

    public int getCompletadoPorcentaje() {
        return completadoPorcentaje;
    }

    public void setCompletadoPorcentaje(int completadoPorcentaje) {
        this.completadoPorcentaje = completadoPorcentaje;
    }

    public Revision getRevision() {
        return revision;
    }

    public void setRevision(Revision revision) {
        this.revision = revision;
    }
}
