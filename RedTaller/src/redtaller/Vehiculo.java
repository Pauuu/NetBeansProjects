package redtaller;

import java.util.*;

public class Vehiculo {

    //atributos
    private Cliente propietario;
    private int matricula;
    private int kilometraje;
    private Taller taller;
    private String marca;
    private String modelo;

    //metodos
    public Vehiculo(Taller b, int k, Cliente p, String mc,
            String md, int mt) {
        this.taller = b;
        this.kilometraje = k;
        this.propietario = p;
        this.marca = mc;
        this.modelo = md;
        this.matricula = mt;
    }

    public Vehiculo() {
        this.taller = null;
        this.kilometraje = 0;
        this.propietario = null;
        this.marca = "Audi";
        this.modelo = "uno";
        this.matricula = 0000;
    }

    public Taller getEnTaller() {
        return taller;
    }

    public void setEnTaller(Taller enTaller) {
        this.taller = enTaller;
    }

    public Cliente getPropietario() {
        return propietario;
    }

    public void setPropietario(Cliente propietario) {
        this.propietario = propietario;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    public int getKilometraje() {
        return kilometraje;
    }

    public void setKilometraje(int kilometraje) {
        this.kilometraje = kilometraje;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

}
