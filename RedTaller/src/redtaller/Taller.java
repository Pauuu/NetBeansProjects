/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package redtaller;

import java.util.*;

/**
 *
 * @author pau
 */
public class Taller {

    //artibutos
    private ArrayList<Cliente> propietarios;
    private ArrayList<Vehiculo> vehiculos;
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
        this.propietarios = new ArrayList();
        this.vehiculos = new ArrayList();
    }
    
    public Vehiculo reportVehiculos(){  //cambiar
        return null;
    }
    
    public Cliente reportClientes(){
        return null;
    }
}
