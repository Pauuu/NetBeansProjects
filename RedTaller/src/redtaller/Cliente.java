package redtaller;

import java.util.*;

public class Cliente {

    //atributos
    private ArrayList<Vehiculo> vehiculo;
    private int dni;
    private int matricula;
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

    public void addVehiculo(Vehiculo v) {
        this.vehiculo.add(v);
    }

    public void reportVehiculo() {
        System.out.println("--------------------------");
        for (int i = 0; i < this.vehiculo.size(); i++) {
            System.out.println(
                    "Nombre"
                        + this.vehiculo.get(i).getTaller().getNombre() +"\n"
                    + "Kilometraje: "
                        + " " + this.vehiculo.get(i).getKilometraje() +"\n"
                    + "Marca"
                        + " " + this.vehiculo.get(i).getMarca() +"\n"
                    + "Modelo" 
                        + " " + this.vehiculo.get(i).getModelo() +"\n"
                    + "Matrícula"
                        + " " + this.vehiculo.get(i).getMatricula()
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

    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    public RedTaller getRedtaller() {
        return redTaller;
    }

    public void setRedtaller(RedTaller redtaller) {
        this.redTaller = redtaller;
    }

}
