package redtaller;

import java.util.*;

public class Cliente {

    //atributos
    private ArrayList<Vehiculo> vehiculo;
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
        this.vehiculo = new ArrayList();
    }

    public void addVehiculo(Vehiculo v) {   //añadir restrincción, solo una misma matrícula por v
        this.vehiculo.add(v);
    }

    public void reportVehiculos() {
        System.out.println("--------------------------");
        for (int i = 0; i < this.vehiculo.size(); i++) {
            System.out.println(
                    "Matrícula"
                    + " " + this.vehiculo.get(i).getMatricula()
                    + "Kilometraje: "
                    + " " + this.vehiculo.get(i).getKilometraje() + "\n"
                    + "Marca"
                    + " " + this.vehiculo.get(i).getMarca() + "\n"
                    + "Modelo"
                    + " " + this.vehiculo.get(i).getModelo() + "\n"
            );
        }
        System.out.println("--------------------------");
    }

    public ArrayList<Vehiculo> getVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(ArrayList<Vehiculo> vehiculo) {
        this.vehiculo = vehiculo;
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
