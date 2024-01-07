package dev.iesfranciscodelosrios.psp_async_navidad.domain.model;

public class Emisores {
    private Revision revision;
    private float indice;
    private boolean testEmisiones;
    private int contador;

    public int getContador() {
        return contador;
    }

    public void setContador(int contador) {
        this.contador = contador;
    }

    public Emisores(Revision revision, float indice, boolean testEmisiones) {
        this.revision = revision;
        this.indice = indice;
        this.testEmisiones = testEmisiones;
    }

    public Emisores() {
    }

    public Revision getRevision() {
        return revision;
    }

    public void setRevision(Revision revision) {
        this.revision = revision;
    }

    public float getIndice() {
        return indice;
    }

    public void setIndice(float indice) {
        this.indice = indice;
    }

    public boolean isTestEmisiones() {
        return testEmisiones;
    }

    public void setTestEmisiones(boolean testEmisiones) {
        this.testEmisiones = testEmisiones;
    }
}
