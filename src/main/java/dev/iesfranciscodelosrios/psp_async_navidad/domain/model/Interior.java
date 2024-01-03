package dev.iesfranciscodelosrios.psp_async_navidad.domain.model;

public class Interior {
    private Revision revision;
    private boolean antirobo;
    private boolean antideslizante;
    private boolean frenado;
    private int contador;

    public int getContador() {
        return contador;
    }

    public void setContador(int contador) {
        this.contador = contador;
    }

    public Interior(Revision revision, boolean antirobo, boolean antideslizante, boolean frenado) {
        this.revision = revision;
        this.antirobo = antirobo;
        this.antideslizante = antideslizante;
        this.frenado = frenado;
    }

    public Interior() {
    }

    public Revision getRevision() {
        return revision;
    }

    public void setRevision(Revision revision) {
        this.revision = revision;
    }

    public boolean isAntirobo() {
        return antirobo;
    }

    public void setAntirobo(boolean antirobo) {
        this.antirobo = antirobo;
    }

    public boolean isAntideslizante() {
        return antideslizante;
    }

    public void setAntideslizante(boolean antideslizante) {
        this.antideslizante = antideslizante;
    }

    public boolean isFrenado() {
        return frenado;
    }

    public void setFrenado(boolean frenado) {
        this.frenado = frenado;
    }
}
