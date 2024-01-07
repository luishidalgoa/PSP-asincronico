package dev.iesfranciscodelosrios.psp_async_navidad.domain.model;

public class Alineacion {
    private Revision revision;
    private boolean volante;
    private boolean testFugas;
    private boolean testDireccion;
    private boolean amortiguacion;
    private int contador;

    public int getContador() {
        return contador;
    }

    public void setContador(int contador) {
        this.contador = contador;
    }

    public Alineacion(Revision revision, boolean volante, boolean testFugas, boolean testDireccion, boolean amortiguacion) {
        this.revision = revision;
        this.volante = volante;
        this.testFugas = testFugas;
        this.testDireccion = testDireccion;
        this.amortiguacion = amortiguacion;
    }

    public Alineacion() {
    }

    public Revision getRevision() {
        return revision;
    }

    public void setRevision(Revision revision) {
        this.revision = revision;
    }

    public boolean isVolante() {
        return volante;
    }

    public void setVolante(boolean volante) {
        this.volante = volante;
    }

    public boolean isTestFugas() {
        return testFugas;
    }

    public void setTestFugas(boolean testFugas) {
        this.testFugas = testFugas;
    }

    public boolean isTestDireccion() {
        return testDireccion;
    }

    public void setTestDireccion(boolean testDireccion) {
        this.testDireccion = testDireccion;
    }

    public boolean isAmortiguacion() {
        return amortiguacion;
    }

    public void setAmortiguacion(boolean amortiguacion) {
        this.amortiguacion = amortiguacion;
    }
}
