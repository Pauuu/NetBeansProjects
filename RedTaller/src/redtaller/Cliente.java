package redtaller;

import java.util.*;

public class Cliente {

    //atributos
    private ArrayList<Vehiculo> vehiculo;
    private int dni;
    private int matricula;
    private String nombre;
    private String apellido;

    //metodos
    public Cliente(int d, String n, String a) {
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
                    this.vehiculo.get(i).getTaller()
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

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }


}
