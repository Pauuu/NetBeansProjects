package redtaller;

import java.util.*;

public class Cliente {

    //atributos
    private ArrayList<Vehiculo> vehiculo;
    private int matricula;
    private String nombre;
    private String apellido;
    private String dni;

    //metodos
    public Cliente(String n, String a, String d) {
        this.nombre = n;
        this.apellido = a;
        this.dni = d;
        this.vehiculo = new ArrayList();
    }

    public void addVehiculo(Vehiculo v) {
        this.vehiculo.add(v);
    }

    public void reportVehiculo() {
        for (int i = 0; i < this.vehiculo.size(); i++) {
            System.out.println(
                    this.vehiculo.get(i).getEnTaller()
                    + " " + this.vehiculo.get(i).getKilometraje()
                    + " " + this.vehiculo.get(i).getMarca()
                    + " " + this.vehiculo.get(i).getModelo()
                    + " " + this.vehiculo.get(i).getMatricula()
            );
        }
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

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }
}
