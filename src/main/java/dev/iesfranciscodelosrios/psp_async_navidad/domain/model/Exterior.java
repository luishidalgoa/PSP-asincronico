package dev.iesfranciscodelosrios.psp_async_navidad.domain.model;

import dev.iesfranciscodelosrios.psp_async_navidad.domain.enums.Neumaticos;

public class Exterior {
    private Revision revision;
    private Neumaticos neumaticos;
    private boolean testLimpiaParabrisas;
    private boolean testLuces;
    private boolean testCinturones;
    private boolean testDeposito;
    private int contador;

    public int getContador() {
        return contador;
    }

    public void setContador(int contador) {
        this.contador = contador;
    }

    public Exterior(Revision revision, Neumaticos neumaticos, boolean testLimpiaParabrisas, boolean testLuces, boolean testCinturones, boolean testDeposito) {
        this.revision = revision;
        this.neumaticos = neumaticos;
        this.testLimpiaParabrisas = testLimpiaParabrisas;
        this.testLuces = testLuces;
        this.testCinturones = testCinturones;
        this.testDeposito = testDeposito;
    }

    public Exterior() {
    }

    public Revision getRevision() {
        return revision;
    }

    public void setRevision(Revision revision) {
        this.revision = revision;
    }

    public Neumaticos getNeumaticos() {
        return neumaticos;
    }

    public void setNeumaticos(Neumaticos neumaticos) {
        this.neumaticos = neumaticos;
    }

    public boolean isTestLimpiaParabrisas() {
        return testLimpiaParabrisas;
    }

    public void setTestLimpiaParabrisas(boolean testLimpiaParabrisas) {
        this.testLimpiaParabrisas = testLimpiaParabrisas;
    }

    public boolean isTestLuces() {
        return testLuces;
    }

    public void setTestLuces(boolean testLuces) {
        this.testLuces = testLuces;
    }

    public boolean isTestCinturones() {
        return testCinturones;
    }

    public void setTestCinturones(boolean testCinturones) {
        this.testCinturones = testCinturones;
    }

    public boolean isTestDeposito() {
        return testDeposito;
    }

    public void setTestDeposito(boolean testDeposito) {
        this.testDeposito = testDeposito;
    }
}
