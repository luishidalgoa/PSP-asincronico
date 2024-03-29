package dev.iesfranciscodelosrios.psp_async_navidad.domain.model;

import dev.iesfranciscodelosrios.psp_async_navidad.Services.ControlAcceso;
import dev.iesfranciscodelosrios.psp_async_navidad.Services.Simulacion;
import dev.iesfranciscodelosrios.psp_async_navidad.domain.enums.Marca;
public class Coche implements Runnable{
    private int id;
    private String matricula;
    private Marca marca;
    private String modelo;

    public Pista pista;

    public Coche(int id, String matricula, Marca marca, String modelo) {
        this.id = id;
        this.matricula = matricula;
        this.marca = marca;
        this.modelo = modelo;
    }
    public Coche(String matricula, Marca marca, String modelo) {
        this.matricula = matricula;
        this.marca = marca;
        this.modelo = modelo;
    }

    public Coche() {
    }

    public Coche(int idCoche) {
        this.id = idCoche;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public Marca getMarca() {
        return marca;
    }

    public void setMarca(Marca marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    @Override
    public void run() {
        pista = ControlAcceso.getInstance().getPista();
        System.out.println("termino el coche"+ id);
    }
}
