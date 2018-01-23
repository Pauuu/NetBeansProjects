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

    /*public void addVehiculo(Vehiculo v) {   //está marcado como en taller y lo mete en el arrayList de vehiculos
        for (Vehiculo vv : vehiculos) { //anyadir busqueda iterativa en un futuro
            if (vv.getMatricula() == v.getMatricula()) { //busca si la matricula es la misma
                System.out.println("Este vehiculo ya está en taller");
                break;
            } else {
                v.setEnTaller(this);
                this.vehiculos.add(v);
            }
        }

        for (Cliente c : clientes) {
            if (c == v.getPropietario()) {  //anyadir busqueda iterativa en un futuro
                break;
            } else {
                this.addCliente(v.getPropietario());
            }
        }
    }*/

    public void addVehiculo2(Vehiculo v) {
        if (v.getEnTaller() == this) {
            System.out.println("El vehiculo con matrícula " + v.getMatricula()
                    + " ya está en el taller");
        } else {
            this.vehiculos.add(v);
            v.setEnTaller(this);
            System.out.println("Vehiculo añadido");
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
