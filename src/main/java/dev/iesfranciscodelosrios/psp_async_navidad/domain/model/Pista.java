package dev.iesfranciscodelosrios.psp_async_navidad.domain.model;

public class Pista {
    public int completadoPorcentaje;
    private Revision revision;
    public int numero;

    public boolean libre = true;

    public Pista(int numero) {
        completadoPorcentaje = 0;
        this.numero= numero;
    }

    public Pista(int numero,Revision revision) {
        this.numero = numero;
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

    public synchronized void ocuparPista() {
        libre = false;
    }

    public synchronized void liberarPista() {
        libre = true;
        notifyAll();
    }
    public boolean getLibre(){
        return libre;
    }
}
