package redtaller;

import java.util.*;

public class Taller {

    //artibutos
    private ArrayList<Cliente> listaClientes;
    private ArrayList<Vehiculo> listaVehiculos;
    private RedTaller redTaller;
    private String direccion;
    private String nombre;
    private int codigo;
    private int tel;

    //metodos
    public Taller(RedTaller t, String d, String n, int c, int tel) {
        this.redTaller = t;
        this.direccion = d;
        this.nombre = n;
        this.codigo = c;
        this.tel = tel;
        this.listaClientes = new ArrayList();
        this.listaVehiculos = new ArrayList();

    }

    public void addCliente(Cliente c) {
        this.listaClientes.add(c);
    }

    public void addVehiculo(Vehiculo v) {
        if (v.getTaller() != null) {
            System.out.println(
                    "Este vehiculo ya está en el taller: \n"
                    + v.getTaller().getNombre() + "\n\n");

        } else {
            v.setTaller(this);
            this.listaVehiculos.add(v);            
            System.out.println("Vehiculo añadido \n\n");
        }
    }

    public void info() {
        System.out.println(this.getNombre()
                + this.getRedTaller() + "\n"
                + this.getCodigo() + "\n"
                + this.listaClientes.size() + "\n"
                + this.listaVehiculos.size()
        );
    }

    public void repararVehiculo(Vehiculo v) {
        v.setTaller(null);
        this.listaVehiculos.remove(v);
        
        if(v.getPropietario().numVehiculos() > 0){
            
        }
        
    }

    public void reportVehiculos() {
        System.out.println("+-----------------------------------+" + "\n"
                + "Lista de vehiculos dentro del taller : \n"
                + this.getNombre());

        for (Vehiculo v : listaVehiculos) {
            System.out.println(
                    "     - - - - - - - - - - - - - - -    " + "\n"
                    + "Matrícula: " + v.getMatricula() + "\n"
                    + "Marca: " + v.getMarca() + "\n"
                    + "DNI propietario: " + " " + v.getPropietario().getDni() + "\n"
                    + "Nombre propietario: " + " " + v.getPropietario().getNombre() + "\n"
                    + "Apellido propietario: " + " " + v.getPropietario().getApellido() + "\n"
                    + "   - - - - - - - - - - - - - - -     "
            );
        }
        System.out.println("+----------------------------------+ \n\n");

    }

    public Cliente reportClientes() {
        return null;
    }

    //GETTERS / SETTERS
    @Override
    public String toString() {
        return ("\n Red taller: " + this.redTaller
                + "\n Codigo taller: " + this.codigo
                + "\n Nombre: " + this.nombre
                + "\n Direccion: " + this.direccion
                + "\n Nº Vehiculos: " + this.listaClientes.size()
                + "\n Nº Clientes: " + this.listaVehiculos.size() + "\n");
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public RedTaller getRedTaller() {
        return redTaller;
    }

    public void setRedTaller(RedTaller redTaller) {
        this.redTaller = redTaller;
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
