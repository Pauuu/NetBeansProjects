package redtaller;

import java.util.*;

public class RedTaller {

    //ATRIBUTOS
    private ArrayList<Cliente> listaClientes;
    private ArrayList<Taller> listaTalleres;
    private ArrayList<Vehiculo> listaVehiculos;

    //METODOS
    public static void main(String[] args) {
        RedTaller red1 = new RedTaller();   //se tiene que crear la red para poder usar los metodos de esta clase(1)
        red1.addCliente(12345678, "manolo", "sanchez");
        red1.addTaller("c/ El Titempo", "Taller Tahoy Tamañana", 0, 0);
        Taller t1 = red1.addTaller("2", "Taller rellat", 2, 2);
        
        System.out.println(t1.getNombre());
    }

    public RedTaller() {
        this.listaClientes = new ArrayList();
        this.listaTalleres = new ArrayList();
        this.listaVehiculos = new ArrayList();
    }

    public void addTaller2(Taller t) {
        this.listaTalleres.add(t);
    }

    private void addCliente(int d, String n, String a) {
        this.listaClientes.add(new Cliente(d, n, a));
        System.out.println("Cliente añadido");

        //this.listaClientes.add(Cliente c = new Cliente("A", "b", "c"));
        //this.addCliente(new Cliente(n, a, d));
    }

    private Taller addTaller(String d, String n, int c, int tel) {
        Taller t = new Taller(d, n, c, tel);
        this.listaTalleres.add(t);
        System.out.println("Taller " + n + " añadido");
        return t;
    }

    private void addVehiculos(Taller b, int k, Cliente p, String mc, String md, int mt) {
        Vehiculo v = new Vehiculo();
        this.listaVehiculos.add(new Vehiculo(b, k, p, mc, md, mt));
        System.out.println("Vehiculo añadido");
    }

    private void infoCliente(Cliente c) {
        System.out.println(c.getNombre() + c.getApellido()
                + c.getDni());
    }

    private void infoTaller(Taller t) {
        System.out.println(t.getDireccion() + t.getNombre()
                + t.getCodigo() + t.getTel());
    }

    private void infoVehiculo(Vehiculo v) {
        System.out.println(v.getMarca() + v.getMatricula()
                + v.getPropietario());
    }

    public ArrayList<Cliente> getClientes() {
        return listaClientes;
    }

    public void setClientes(ArrayList<Cliente> clientes) {
        this.listaClientes = clientes;
    }

    public ArrayList<Taller> getTalleres() {
        return listaTalleres;
    }

    public void setTalleres(ArrayList<Taller> talleres) {
        this.listaTalleres = talleres;
    }

    public ArrayList<Vehiculo> getVehiculo() {
        return listaVehiculos;
    }

    public void setVehiculo(ArrayList<Vehiculo> vehiculo) {
        this.listaVehiculos = vehiculo;
    }

}
