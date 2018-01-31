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

        Taller t1 = red1.crearTaller("c/ El Titempo", "Taller Tahoy Tamañana", 0, 0);
        Cliente c1 = red1.crearCliente(12345678, "Chris", "Fontdescuberta");
        Vehiculo v1 = red1.crearVehiculo(0, c1, "Audio", "Stereoso", 2728);
        red1.infoClienteDni2(123456878);

        c1.addVehiculo(v1);
        red1.infoMaricula2(2728);

        t1.addVehiculo4(v1);
        c1.reportVehiculo();
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
    private void cambioPropietario(Vehiculo vViejo, Vehiculo vNuevo, Cliente c1) {
        vNuevo.setPropietario(c1);
        vViejo.setPropietario(null);
    }

    private Cliente busquedaCliente(int dni) {
        for (int i = 0; i < listaClientes.size(); i++) {
            if (dni == listaClientes.get(i).getDni()) {
                return listaClientes.get(i);
            }
        }
        return null;
    }

    private Vehiculo busquedaVehiculo(int matr) {
        for (int i = 0; i < listaVehiculos.size(); i++) {
            if (matr == listaVehiculos.get(i).getMatricula()) {
                return listaVehiculos.get(i);
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

    
    private Cliente crearCliente2(int dni, String nombre, String apellido) { //cambiar esta rutina
        if (this.busquedaCliente(dni) == null) {    //así?????
            Cliente c = new Cliente(this, dni, nombre, apellido);
            this.listaClientes.add(c);
            System.out.println("Cliente añadido \n\n");
            return c;
        } else {
            System.out.println("Este cliente ya se encuentra dentro del RedTaller \n\n");
            return null;
        }
    }

    private Taller crearTaller(String d, String n, int c, int tel) {
        Taller t = new Taller(this, d, n, c, tel);
        this.listaTalleres.add(t);
        System.out.println("Taller " + n + " añadido \n\n");
        return t;

        //this.listaTalleres.add(new Taller(d, n, c, tel));
    }

    private void infoClienteDni2(int dni) {
        Cliente c = busquedaCliente(dni);   //camibar
        if (c != null) {
            System.out.println(
                    "-------------------------------------" + "\n"
                    + "Información del cliente con DNI: " + c.getDni() + "\n"
                    + "Nombre: " + c.getNombre() + "\n"
                    + "Apellido: " + c.getApellido() + "\n"
                    + "-------------------------------------\n\n");
        } else {
            System.out.println("El cliente con DNI: " + dni
                    + " no se encuentra registrado \n\n");
        }
    }

 
    private void infoTallerCodigo(int codigo) {
        for (Taller t : listaTalleres) { //por cada obj.Cliente c de "listaClientes" //poner bucles normal (?)
            if (codigo == t.getCodigo()) {                                //para pomer el "if"
                System.out.println(
                        "-------------------------------------" + "\n"
                        + "Información del cliente con DNI: " + t.getDireccion() + "\n"
                        + "Nombre: " + t.getNombre() + "\n"
                        + "Apellido: " + t.getTel() + "\n"
                        + "-------------------------------------\n\n"
                );
                break;
            }

        }
    }

    private void infoTallerCodigo2(int codigo) {
        Taller t = busquedaTaller(codigo);
        if (t != null) {
            System.out.println(
                    "-------------------------------------" + "\n"
                    + "Información del cliente con DNI: " + t.getDireccion() + "\n"
                    + "Nombre: " + t.getNombre() + "\n"
                    + "Apellido: " + t.getTel() + "\n"
                    + "-------------------------------------\n\n"
            );
        } else {
            System.out.println("El taller con código: " + codigo
                    + " no se encuentra registrado \n\n");
        }
    }

    private void infoVehiculoMatricula(int matr) {
        for (Vehiculo v : listaVehiculos) { //por cada obj.Cliente c de "listaClientes"
            if (matr == v.getMatricula()) {
                System.out.println(
                        "--------------- \n"
                        + "Propietario: "
                        + ((v.getPropietario() == null) ? " sin propietario" : v.getPropietario().getDni()) + "\n"
                        + "Matricula: " + v.getMatricula() + "\n"
                        + "Marca: " + v.getMarca() + "\n"
                        + "Kilometraje: " + v.getKilometraje() + "\n"
                        + "\n---------------- \n\n"
                );
            }
        }
    }

    private void infoVehiculoMatricula2(int matr) {
        Vehiculo v = busquedaVehiculo(matr);
        if (v != null) {
            System.out.println(
                    "--------------- \n"
                    + "Propietario: "
                    + ((v.getPropietario() == null) ? " sin propietario" : v.getPropietario().getDni()) + "\n"
                    + "Matricula: " + v.getMatricula() + "\n"
                    + "Marca: " + v.getMarca() + "\n"
                    + "Kilometraje: " + v.getKilometraje() + "\n"
                    + "\n---------------- \n\n"
            );
        } else {
            System.out.println("El vehiculo con matrícula: " + matr
                    + " no se encuentra registrado \n\n");
        }
    }

    private Vehiculo crearVehiculo(int k, Cliente p, String mc, String md, int mt) {
        Vehiculo v = new Vehiculo(this, k, p, mc, md, mt);
        this.listaVehiculos.add(v);
        System.out.println("Vehiculo añadido \n\n");
        return v;

        //this.listaTalleres.add(new Vehiculo(b, k, p, mc, md, mt));
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
