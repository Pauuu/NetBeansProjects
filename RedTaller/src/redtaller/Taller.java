package redtaller;

import java.util.*;

public class Taller {

    //artibutos
    private ArrayList<Cliente> clientes;
    private ArrayList<Vehiculo> vehiculos;
    private ArrayList<String> nameClientes;
    private String direccion;
    private String nombre;
    private int codigo;
    private int tel;

    //metodos
    public Taller(String d, String n, int c, int t) {
        this.direccion = d;
        this.nombre = n;
        this.codigo = c;
        this.tel = t;
        this.clientes = new ArrayList();
        this.vehiculos = new ArrayList();

    }

    public void addCliente(Cliente c) {
        this.clientes.add(c);
    }

    /*public void addVehiculo2(Vehiculo v) {  //añadir renstriccion: 1 vehi. -> 1 taller
        if (v.getEnTaller() == this) {
            System.out.println("El vehiculo con matrícula " + v.getMatricula() + " ya está en el taller");
        } else if (v.isEnTaller() == true) {
            System.out.println("El vehiculo con matrícula " + v.getMatricula() + " ya está en otro taller");
        } else {
            this.vehiculos.add(v);
            v.setTaller(this);
            System.out.println("Vehiculo añadido");
        }
        this.addCliente(v.getPropietario());    //buscar antes si está en el taller o no
    }*/
    public void addVehiculo3(Vehiculo v) {
        if (v.getEnTaller() != null) {
            v.setTaller(this);
            System.out.println("Vehiculo añadido");
        } else {
            System.out.println("Este vehiculo ya está en el taller" + v.getEnTaller().getNombre());
        }
    }

    public void repararVehiculo(Vehiculo v) {
        v.setEnTaller(null);
        this.vehiculos.remove(v);
    }

    public Vehiculo reportVehiculos() {  //cambiar
        return null;
    }

    public Cliente reportClientes() {
        return null;
    }

    //GETTERS / SETTERS
    public ArrayList<Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(ArrayList<Cliente> clientes) {
        this.clientes = clientes;
    }

    public ArrayList<Vehiculo> getVehiculos() {
        return vehiculos;
    }

    public void setVehiculos(ArrayList<Vehiculo> vehiculos) {
        this.vehiculos = vehiculos;
    }

    public ArrayList<String> getNameClientes() {
        return nameClientes;
    }

    public void setNameClientes(ArrayList<String> nameClientes) {
        this.nameClientes = nameClientes;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public int getTel() {
        return tel;
    }

    public void setTel(int tel) {
        this.tel = tel;
    }

}
