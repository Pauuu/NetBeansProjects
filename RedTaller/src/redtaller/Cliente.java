package redtaller;

import java.util.*;

public class Cliente {

    //atributos
    private ArrayList<Vehiculo> listaVehiculos;
    private int dni;
    private RedTaller redTaller;
    private String nombre;
    private String apellido;

    //metodos
    public Cliente(RedTaller t, int d, String n, String a) {
        this.redTaller = t;
        this.nombre = n;
        this.apellido = a;
        this.dni = d;
        this.listaVehiculos = new ArrayList();
    }

    public void addVehiculo(Vehiculo v) {   //añadir restrincción, solo una misma matrícula por v
        this.listaVehiculos.add(v);
        v.setPropietario(this);
    }

    public void info() {
        System.out.println(this.getNombre()
                + this.getApellido() + "\n"
                + this.getDni() + "\n"
                + this.listaVehiculos.size()
        );
    }

    public void reportVehiculos() {
        System.out.println("--------------------------");
        for (int i = 0; i < this.listaVehiculos.size(); i++) {
            System.out.println("Matrícula"
                    + " " + this.listaVehiculos.get(i).getMatricula()
                    + "Kilometraje: "
                    + " " + this.listaVehiculos.get(i).getKilometraje() + "\n"
                    + "Marca"
                    + " " + this.listaVehiculos.get(i).getMarca() + "\n"
                    + "Modelo"
                    + " " + this.listaVehiculos.get(i).getModelo() + "\n"
            );
        }
        System.out.println("--------------------------");
    }

    @Override
    public String toString() {
        return ("\n Red taller: " + this.redTaller
                + "\n DNI: " + this.dni
                + "\n Nombre: " + this.nombre
                + "\n Apellido: " + this.apellido
                + "\n Nº Vehiculos:" + this.listaVehiculos.size() + "\n");
    }

    public int numVehiculos(){
        return listaVehiculos.size();
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public RedTaller getRedtaller() {
        return redTaller;
    }

    public void setRedtaller(RedTaller redtaller) {
        this.redTaller = redtaller;
    }

}
