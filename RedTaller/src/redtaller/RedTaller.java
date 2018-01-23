package redtaller;

import java.util.*;

public class RedTaller {

    //ATRIBUTOS
    ArrayList<Cliente> clientes;
    ArrayList<Taller> talleres;
    ArrayList<Vehiculo> vehiculo;

    //METODOS
    public static void main(String[] args) {
        RedTaller red1 = new RedTaller();   //se tiene que crear la red para poder usar los metodos de esta clase(1)
        Taller t1 = new Taller("Direccion aleatoria","Taller 1",2,2);
        Taller t2 = new Taller ("Direccion aleatoria","Taller 2",44,44);
        Cliente fulano = new Cliente("A", "b", "c");

        Vehiculo buga1 = new Vehiculo(t1, 232, fulano, "Audio", "hika", 3456);
        Vehiculo buga2 = new Vehiculo(t1, 232, fulano, "VeusSiBaden", "roma", 1488);
        Vehiculo buga3 = new Vehiculo();

        //le damos coches a fulano
        fulano.addVehiculo(buga1);
        fulano.addVehiculo(buga2);
        fulano.addVehiculo(buga3);
        
        t1.addVehiculo2(buga1);
        t1.addVehiculo2(buga1);
        t1.repararVehiculo(buga1);
        t1.addVehiculo2(buga1);
        //red1.reportVehiculo(buga); //(1)
        fulano.reportVehiculo();


        red1.infoVehiculo(buga1);

    }

    public RedTaller() {
        this.talleres = new ArrayList();
    }

    private void addCliente(Cliente c) {
        this.clientes.add(c);
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
        return clientes;
    }

    public void setClientes(ArrayList<Cliente> clientes) {
        this.clientes = clientes;
    }

    public ArrayList<Taller> getTalleres() {
        return talleres;
    }

    public void setTalleres(ArrayList<Taller> talleres) {
        this.talleres = talleres;
    }

    public ArrayList<Vehiculo> getVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(ArrayList<Vehiculo> vehiculo) {
        this.vehiculo = vehiculo;
    }

}
