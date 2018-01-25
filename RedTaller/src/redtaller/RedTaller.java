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
        Taller t1 = red1.addTaller("c/ El Titempo", "Taller Tahoy Tamañana", 0, 0);
        Cliente c1 = red1.addCliente(12345678, "manolo", "sanchez");

        red1.addVehiculo(t1, 0, c1, "2323", "modelo", 2728);

        System.out.println(t1.getNombre());
        red1.infoClienteDni(12345678);
        red1.infoVehiculoMatricula(2728);
        
        t1.reportVehiculos();
    }

    public RedTaller() {
        this.listaClientes = new ArrayList();
        this.listaTalleres = new ArrayList();
        this.listaVehiculos = new ArrayList();
    }

    /* 
    *   Crea un cliente con sus atributos,
    *   lo añade en el arrayList,
    *   muestra un mensaje informativo,
    *   devuelve el Cliente.
    */
    private Cliente addCliente(int d, String n, String a) {
        Cliente c = new Cliente(d, n, a);
        this.listaClientes.add(c);
        System.out.println("Cliente añadido");
        return c;

        //this.listaClientes.add(Cliente c = new Cliente("A", "b", "c"));
        //this.addCliente(new Cliente(n, a, d));
    }

    private Taller addTaller(String d, String n, int c, int tel) {
        Taller t = new Taller(d, n, c, tel);
        this.listaTalleres.add(t);
        System.out.println("Taller " + n + " añadido");
        return t;

        //this.listaTalleres.add(new Taller(d, n, c, tel));
    }

    private Vehiculo addVehiculo(Taller b, int k, Cliente p, String mc, String md, int mt) {
        Vehiculo v = new Vehiculo(b, k, p, mc, md, mt);
        this.listaVehiculos.add(v);
        System.out.println("Vehiculo añadido");
        return v;

        //this.listaTalleres.add(new Vehiculo(b, k, p, mc, md, mt));
    }

    private void infoCliente(Cliente c) {
        System.out.println(c.getNombre() + c.getApellido()
                + c.getDni());
    }

    private void infoClienteDni(int dni) {
        for (Cliente c : listaClientes) { //por cada obj.Cliente c de "listaClientes"
            if (dni == c.getDni()) {
                System.out.println(c.getNombre() + " " + c.getApellido()
                        + " " + c.getDni());
                break;
            }
        }
        System.out.println("El cliente con DNI: " + dni
                + " no se encuentra registrado");
    }

    private void infoTaller(Taller t) {
        System.out.println(t.getDireccion() + t.getNombre()
                + t.getCodigo() + t.getTel());
    }

    private void infoVehiculoMatricula(int matr) {
        for (Vehiculo v : listaVehiculos) { //por cada obj.Cliente c de "listaClientes"
            if (matr == v.getMatricula()) {
                if (v.getPropietario() == null) {
                    System.out.println(v.getMatricula() + " " + v.getKilometraje()
                            + " " + v.getMarca() + " sin propietario");
                    break;
                } else {
                    System.out.println(v.getMatricula() + " " + v.getKilometraje()
                            + " " + v.getMarca() + " " + v.getPropietario().getDni());
                    break;
                }
            }
        }
    }

    private void infoVehiculo(Vehiculo v) {
        System.out.println(v.getMarca() + v.getMatricula()
                + v.getPropietario());
    }

    //GETTERS / SETTERS 
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
