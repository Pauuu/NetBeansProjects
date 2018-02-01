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

        red1.reportTalleres();
        red1.reportClientes();
        red1.reportVehiculos();
        

    }

    public RedTaller() {
        this.listaClientes = new ArrayList();
        this.listaTalleres = new ArrayList();
        this.listaVehiculos = new ArrayList();
    }

    //BUSQUEDAS    
    private Cliente busquedaCliente(int dni) {
        for (int i = 0; i < listaClientes.size(); i++) {
            if (dni == listaClientes.get(i).getDni()) {
                return listaClientes.get(i);
            }
        }
        return null;
    }

    private Taller busquedaTaller(int codigo) {
        for (int i = 0; i < listaTalleres.size(); i++) {
            if (codigo == listaTalleres.get(i).getCodigo()) {
                return listaTalleres.get(i);
            }
        }
        return null;
    }

    private Vehiculo busquedaVehiculo(int matricula) {
        for (int i = 0; i < listaVehiculos.size(); i++) {
            if (matricula == listaVehiculos.get(i).getMatricula()) {
                return listaVehiculos.get(i);
            }
        }
        return null;
    }

    //CREACION OBJETOS EN LA RED
    private boolean crearCliente(int dni, String nombre, String apellido) {
        if (this.busquedaCliente(dni) != null) {
            return false; // No creado porque ya existe =======================>
        }

        this.listaClientes.add(new Cliente(this, dni, nombre, apellido));

        return true;
    }

    private boolean crearTaller(String d, String n, int codigo, int tel) {
        if (busquedaTaller(codigo) != null) {
            return false;
        }

        this.listaTalleres.add(new Taller(this, d, n, codigo, tel));
        return true;
    }

    private boolean crearVehiculo(String mc, int k, String marca, String modelo, int matricula) {
        if (busquedaVehiculo(matricula) != null) {
            return false;
        }
        this.listaVehiculos.add(new Vehiculo(this, matricula, k, marca, modelo));
        return true;
    }

    //CAMBIO DE PROPIETARIO
    private void cambioPropietario(int vViejo, int vNuevo, int cliente) {
        Vehiculo v = busquedaVehiculo(vViejo);
        Vehiculo n = busquedaVehiculo(vNuevo);
        Cliente c = busquedaCliente(cliente);

        if (v == null || n == null) {
            System.out.println("El vehiculo con matricula: " + vNuevo + "no existe");
        } else {
            n.setPropietario(c);
            v.setPropietario(null);
        }

        /* vNuevo.setPropietario(c1);
        vViejo.setPropietario(null);*/
    }

    //REPORTs
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

    //INFORMACION SOBRE OBJETOS
    private void infoCliente(int dni) {
        Cliente c = busquedaCliente(dni);

        if (busquedaCliente(dni) == null) {
            System.out.println("El cliente con dni: " + dni + " ,no existe");
        } else {
            System.out.println(
                    c.getDni() + "\n"
                    + c.getNombre()
            );
        }
    }

    private void infoTaller(int codigo) {
        Taller t = busquedaTaller(codigo);

        if (busquedaCliente(codigo) == null) {
            System.out.println("El taller con código : " + codigo + " ,no existe");
        } else {

        }
    }

    private void infoVehiculo(int matricula) {
        Vehiculo v = busquedaVehiculo(matricula);

        if (busquedaCliente(matricula) == null) {
            System.out.println("El vehiculo con : " + matricula + " ,no existe");
        } else {
            v.info();
        }
    }
}
