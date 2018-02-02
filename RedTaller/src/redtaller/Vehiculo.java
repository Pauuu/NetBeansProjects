package redtaller;

import java.util.*;

public class Vehiculo {

    //atributos
    private Cliente propietario;
    private int matricula;
    private int kilometraje;
    private RedTaller redTaller;
    private Taller taller;
    private String marca;
    private String modelo;

    //metodos
    public Vehiculo(RedTaller t, int mt, int k, String mc, String md) {
        this.redTaller = t;
        this.taller = null;
        this.kilometraje = k;
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

    public void info() {
        System.out.println(
                this.getTaller() + "\n"
                + this.getMatricula() + "\n"
                + this.getKilometraje() + "\n"
                + this.getMarca() + "\n"
                + this.getModelo() + "\n"
        );
    }

    //GETTERS  / SETTERS
    
    @Override
    public String toString() {
        return ("\n Red taller: " + this.redTaller
                + "\n Taller: " + this.taller
                + "\n Propietario: " + this.propietario
                + "\n Nombre: " + this.matricula
                + "\n Marca: " + this.marca
                + "\n Modelo: " + this.modelo
                + "\n Kilometraje: "+ this.kilometraje);
    }
    
    public void propietario() {
        System.out.println(this.getPropietario().getNombre());
    }

    public Taller getTaller() {
        return taller;
    }

    public void setTaller(Taller taller) {
        this.taller = taller;
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

    public RedTaller getRedtaller() {
        return redTaller;
    }

    public void setRedtaller(RedTaller redtaller) {
        this.redTaller = redtaller;
    }

}
