package redtaller;

import java.util.*;

public class Vehiculo {

    //atributos
    private boolean enTaller;
    private Cliente propietario;
    private int kilometraje;
    private String marca;
    private String modelo;
    private String matricula;

    //metodos
    public Vehiculo(boolean b, int k, Cliente p, String mc,
            String md, String mt) {
        this.enTaller = b;
        this.kilometraje = k;
        this.propietario = p;
        this.marca = mc;
        this.modelo = md;
        this.matricula = mt;
    }
    
    public Vehiculo(){
        this.enTaller = false;
        this.kilometraje = 0;
        this.propietario = null;
        this.marca = "Audi";
        this.modelo = "uno";
        this.matricula = "A0000";
    }

    public boolean isEnTaller() {
        return enTaller;
    }

    public void setEnTaller(boolean enTaller) {
        this.enTaller = enTaller;
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

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
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
