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
        red1.addCliente(12345678, "manolo", "sanchez");
    }

    public RedTaller() {
        this.listaClientes = new ArrayList();
        this.listaTalleres = new ArrayList();
        this.listaVehiculos = new ArrayList();
    }

    private void addCliente(int d, String n, String a) {
        this.listaClientes.add(new Cliente(d, n, a));
        System.out.println("Cliente añadido");

        //this.listaClientes.add(Cliente c = new Cliente("A", "b", "c"));
        //this.addCliente(new Cliente(n, a, d));
    }

    private void addTaller(String n, String a, int c, int t) {
        this.listaTalleres.add(new Taller(n, a, c, t));
        System.out.println("Taller añadido");
    }

    private void addVehiculos(Taller b, int k, Cliente p, String mc, String md, int mt) {
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
