package redtaller;

import java.util.*;

public class Taller {

    //artibutos
    private ArrayList<Cliente> listaClientes;
    private ArrayList<Vehiculo> listaVehiculos;
    //private ArrayList<Integer> regClientes;
    //private ArrayList<Integer> regVehiculos;
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
 /* public void addVehiculo3(Vehiculo v) {
        if (v.getTaller() != null) {  //si no está en un taller, añadirlo al taller y al registro
            v.setTaller(this);
            this.listaVehiculos.add(v);
            //this.regVehiculos.add(v.getMatricula());
            
            if (v.getPropietario() != null) {
                this.regClientes.add(v.getPropietario().getDni());
            } else {
               this.regClientes.add(null); 
            }
            
            System.out.println("Vehiculo añadido");
        } else {    //si lo está, imprime siguiente mensaje:
            System.out.println("Este vehiculo ya está en el taller "
                    + v.getTaller().getNombre());
        }

    }
     */
    public void addVehiculo4(Vehiculo v) {
        if (v.getTaller() == null) {
            v.setTaller(this);
            this.listaVehiculos.add(v);
            System.out.println("Vehiculo añadido \n\n");
        } else {
            System.out.println(
                    "Este vehiculo ya está en el taller: \n"
                    + v.getTaller().getNombre() + "\n\n");
        }
    }

    

    public void repararVehiculo(Vehiculo v) {
        v.setTaller(null);
        this.listaVehiculos.remove(v);
    }

    public void reportVehiculos() {  //cambiar
        System.out.println("-------------------------------------");
        System.out.println("Lista de vehiculos dentro del taller : \n"
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
        System.out.println("------------------------------------ \n\n");

    }

    public Cliente reportClientes() {
        return null;
    }

    //GETTERS / SETTERS
    public ArrayList<Cliente> getClientes() {
        return listaClientes;
    }

    public void setClientes(ArrayList<Cliente> clientes) {
        this.listaClientes = clientes;
    }

    public ArrayList<Vehiculo> getVehiculos() {
        return listaVehiculos;
    }

    public void setVehiculos(ArrayList<Vehiculo> vehiculos) {
        this.listaVehiculos = vehiculos;
    }

    /*
    public ArrayList<Integer> getRegClientes() {
        return regClientes;
    }

    public void setRegClientes(ArrayList<Integer> regClientes) {
        this.regClientes = regClientes;
    }

    public ArrayList<Integer> getRegVehiculos() {
        return regVehiculos;
    }

    public void setRegVehiculos(ArrayList<Integer> regVehiculos) {
        this.regVehiculos = regVehiculos;
    }
     */
    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public ArrayList<Cliente> getListaClientes() {
        return listaClientes;
    }

    public void setListaClientes(ArrayList<Cliente> listaClientes) {
        this.listaClientes = listaClientes;
    }

    public ArrayList<Vehiculo> getListaVehiculos() {
        return listaVehiculos;
    }

    public void setListaVehiculos(ArrayList<Vehiculo> listaVehiculos) {
        this.listaVehiculos = listaVehiculos;
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
