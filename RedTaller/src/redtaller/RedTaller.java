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

        red1.crearTaller("c/ El Titempo", "Taller Tahoy Tamañana", 0, 971000000);
        red1.crearTaller("Las Palmas", "Taller Rallao", 1, 971666666);

        red1.crearCliente(12345678, "Chris", "Fontdescuberta");
        red1.crearCliente(99945678, "abc", "def");
        red1.crearCliente(12344548, "xyz", "123");

        red1.crearVehiculo("audio", 0, "audio", "modelo", 1234);
        
        red1.addVehiculoToCliente(1234, 12345678);
        
        red1.infoCliente(123455678);
        red1.infoVehiculo(1234);

        red1.reportTalleres();
        red1.reportClientes();
        red1.reportVehiculos();

    }

    public RedTaller() {
        this.listaClientes = new ArrayList();
        this.listaTalleres = new ArrayList();
        this.listaVehiculos = new ArrayList();
    }

    //Busquedas    
    private Cliente buscarCliente(int dni) {
        for (int i = 0; i < this.listaClientes.size(); i++) {
            if (dni == listaClientes.get(i).getDni()) {
                return listaClientes.get(i);
            }
        }
        return null;
    }

    private Taller buscarTaller(int codigo) {
        for (int i = 0; i < listaTalleres.size(); i++) {
            if (codigo == listaTalleres.get(i).getCodigo()) {
                return listaTalleres.get(i);
            }
        }
        return null;
    }

    private Vehiculo buscarVehiculo(int matricula) {
        for (int i = 0; i < listaVehiculos.size(); i++) {
            if (matricula == listaVehiculos.get(i).getMatricula()) {
                return listaVehiculos.get(i);
            }
        }
        return null;
    }

    //Creacion objetos de la red
    private boolean crearCliente(int dni, String nombre, String apellido) {
        if (this.buscarCliente(dni) != null) {
            return false; //======= No creado porque ya existe ================>
        }

        this.listaClientes.add(new Cliente(this, dni, nombre, apellido));

        return true;
    }

    private boolean crearTaller(String direccion, String nombre, int codigo, int tel) {
        if (buscarTaller(codigo) != null) {
            return false; //======= No creado porque ya existe ================>
        }

        this.listaTalleres.add(new Taller(this, direccion, nombre, codigo, tel));
        return true;
    }

    private boolean crearVehiculo(String mc, int k, String marca, String modelo, int matricula) {
        if (buscarVehiculo(matricula) != null) {
            return false; //======= No creado porque ya existe ================>
        }
        
        this.listaVehiculos.add(new Vehiculo(this, matricula, k, marca, modelo));
        return true;
    }

    //Add
    private void addVehiculoToCliente(int matricula, int dni) {
        Vehiculo v = buscarVehiculo(matricula);
        Cliente c = buscarCliente(dni);

        if (v == null || c == null) {
            System.out.println(v == null ? "El vehiculo no existe" : "El cliente no existe");
        } else {
            c.addVehiculo(v);
        }
    }

    private void addVehiculoToTaller(int matricula, int codigo) {
        Vehiculo v = buscarVehiculo(matricula);
        Taller t = buscarTaller(codigo);

        if (v == null || t == null) {
            System.out.println(v == null ? "El vehiculo no existe" : "El taller no existe");
        } else {
            t.addVehiculo(v);
            t.addCliente(v.getPropietario());
        }
    }

    //Reparar vehiculo
    private void repararvehiculo(int codigo, int matricula) {
        Taller t = buscarTaller(codigo);
        Vehiculo v = buscarVehiculo(matricula);

        if (t == null || v == null) {
            System.out.println(v == null ? "Este vehiculo no existe" : "Este taller no existe");
        } else {
            t.repararVehiculo(v);
        }

    }

    //Cambio de propietario
    private void cambioPropietario(int vViejo, int vNuevo, int cliente) {
        Vehiculo v = buscarVehiculo(vViejo);
        Vehiculo n = buscarVehiculo(vNuevo);
        Cliente c = buscarCliente(cliente);

        if (v == null || n == null) {
            System.out.println("El vehiculo con matricula: " + vNuevo + "no existe");
        } else {
            n.setPropietario(c);
            v.setPropietario(null);
        }

        /* vNuevo.setPropietario(c1);
        vViejo.setPropietario(null);*/
    }

    //Reports
    private void reportClientes() {
        for (int c = 0; c < listaClientes.size(); c++) {
            System.out.println("Cliente " + c + ": " + listaClientes.get(c));
        }
    }

    private void reportTalleres() {
        for (int t = 0; t < listaTalleres.size(); t++) {
            System.out.println("Taller" + t + ": " + listaTalleres.get(t));
        }
    }

    private void reportVehiculos() {
        for (int v = 0; v < listaVehiculos.size(); v++) {
            System.out.println("Vehiculo: " + v + listaVehiculos.get(v));
        }
    }

    //Info sobre un objeto en especifio
    private void infoCliente(int dni) {
        Cliente c = buscarCliente(dni);

        if (buscarCliente(dni) == null) {
            System.out.println("El cliente con dni: " + dni + ", no existe \n");
        } else {
            System.out.println(listaClientes.get(listaClientes.indexOf(c)));
        }
    }

    private void infoTaller(int codigo) {
        Taller t = buscarTaller(codigo);

        if (buscarCliente(codigo) == null) {
            System.out.println("El taller con código : " + codigo + " ,no existe");
        } else {
            System.out.println(listaTalleres.get(listaTalleres.indexOf(t)));
        }
    }

    private void infoVehiculo(int matricula) {
        Vehiculo v = buscarVehiculo(matricula);

        if (buscarVehiculo(matricula) == null) {
            System.out.println("El vehiculo con : " + matricula + " ,no existe");
        } else {
            System.out.println(listaVehiculos.get(listaVehiculos.indexOf(v)));
        }
    }
}
