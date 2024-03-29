package dev.iesfranciscodelosrios.psp_async_navidad.domain.model;

import dev.iesfranciscodelosrios.psp_async_navidad.Services.Progress;

import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalTime;

public class Revision extends Progress {
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

    public Revision(Coche coche) {
        this.identificacion= new Identificacion(this, coche);
        this.exterior = new Exterior(this,false,false,false,false,false);
        this.interior = new Interior(this,false,false,false);
        this.exterior = new Exterior(this,false,false,false,false,false);
        this.alineacion= new Alineacion(this,false,false,false,false);
        this.emisores = new Emisores(this,-1,false);
        this.estado = false;
        this.fecha = Date.valueOf(LocalDate.now());
    }

    public Revision(int idRev) {
        this.id = idRev;
    }
    public Revision(){}

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
