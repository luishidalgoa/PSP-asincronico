package dev.iesfranciscodelosrios.psp_async_navidad.domain.model;

import java.sql.Date;
import java.time.LocalTime;

public class Revision {
    private int id;
    private Date fecha;
    private boolean estado;
    private Identificacion identificacion;
    private Exterior exterior;
    private Interior interior;
    private Alineacion alineacion;
    private Emisores emisores;

    public Revision(int id, Date fecha, boolean estado, Identificacion identificacion, Exterior exterior, Interior interior, Alineacion alineacion, Emisores emisores) {
        this.id = id;
        this.fecha = fecha;
        this.estado = estado;
        this.identificacion = identificacion;
        this.exterior = exterior;
        this.interior = interior;
        this.alineacion = alineacion;
        this.emisores = emisores;
    }

    public Revision(Date fecha, boolean estado, Identificacion identificacion, Exterior exterior, Interior interior, Alineacion alineacion, Emisores emisores) {
        this.fecha = fecha;
        this.estado = estado;
        this.identificacion = identificacion;
        this.exterior = exterior;
        this.interior = interior;
        this.alineacion = alineacion;
        this.emisores = emisores;
    }

    public Revision() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public Identificacion getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(Identificacion identificacion) {
        this.identificacion = identificacion;
    }

    public Exterior getExterior() {
        return exterior;
    }

    public void setExterior(Exterior exterior) {
        this.exterior = exterior;
    }

    public Interior getInterior() {
        return interior;
    }

    public void setInterior(Interior interior) {
        this.interior = interior;
    }

    public Alineacion getAlineacion() {
        return alineacion;
    }

    public void setAlineacion(Alineacion alineacion) {
        this.alineacion = alineacion;
    }

    public Emisores getEmisores() {
        return emisores;
    }

    public void setEmisores(Emisores emisores) {
        this.emisores = emisores;
    }
}
