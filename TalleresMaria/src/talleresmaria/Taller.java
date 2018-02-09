/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package talleresmaria;

import java.util.ArrayList;

public class Taller {

    private ArrayList<Coche> cochesEnReparacion;
    private int codigo;
    private int telefono;
    private RedTalleresMaria red;
    private String direccion;
    private String nombre;

    public Taller(RedTalleresMaria r, int codigo, int telefono, String direccion, String nombre) {
        this.red = r;
        this.codigo = codigo;
        this.telefono = telefono;
        this.direccion = direccion;
        this.nombre = nombre;
        this.cochesEnReparacion = new ArrayList();
    }

    public boolean devolverCoche(String matricula) {
        if (this.findCoche(matricula) == null) {
            System.out.println("El coche con matrícula " + matricula + " no está en reparación.");
            return false; // ======== El coche NO está en reparación ==========>
        }

        // Entregamos el vehiculo
        this.cochesEnReparacion.remove(red.findCoche(matricula));
        red.findCoche(matricula).setTaller(null);

        return true;
    }

    public Coche findCoche(String matricula) {
        for (int i = 0; i < this.cochesEnReparacion.size(); i++) {
            if (this.cochesEnReparacion.get(i).getMatricula().equalsIgnoreCase(matricula)) {
                return this.cochesEnReparacion.get(i); // ====== encontrado Coche =========>
            }
        }

        return null; // ==========coche NO encontrado =========================>
    }

    public int getCodigo() {
        return this.codigo;
    }

    public int getTelefono() {
        return this.telefono;
    }

    public RedTalleresMaria getRed() {
        return this.red;
    }

    public String getDireccion() {
        return this.direccion;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void infoTaller() {
        System.out.println("---------------");
        System.out.println("Ficha de taller");
        System.out.println("---------------");
        System.out.println("Código: " + this.getCodigo());
        System.out.println("Nombre: " + this.getNombre());
        System.out.println("Dirección: " + this.getDireccion());
        System.out.println("Teléfono: " + this.getTelefono());
        System.out.println("");

        if (this.cochesEnReparacion.size() > 0) {
            System.out.println("*** VEHÍCULOS EN REPARACIÓN ***");
            for (int i = 0; i < this.cochesEnReparacion.size(); i++) {
                System.out.println("Vehículo " + (i + 1));
                System.out.println("----------");
                System.out.println("Matrícula: " + cochesEnReparacion.get(i).getMatricula());
                System.out.println("Propietario:   DNI " + cochesEnReparacion.get(i).getPropietario().getDni());
            }
        } else {
            System.out.println("EN ESTOS MOMENTOS NO HAY NINGÚN VEHÍCULO EN REPARACIÓN EN ESTE TALLER");
        }
    }

    public boolean repararCoche(String matricula) {

        if (this.red.findCoche(matricula) == null) {
            System.out.println("El coche con matrícula " + matricula + " no se encuentra en nuestra base de datos.");
            return false; // ========= El coche NO existe en la BD ============>
        }

        if (this.findCoche(matricula) != null) {
            System.out.println("El coche con matrícula " + matricula + " ya está reparándose en el taller " + this.getNombre());
            return false; // ======== El coche YA está en reparacion ==========>
        }

        // Entrada en taller!!!!!!!!!!!!
        this.cochesEnReparacion.add(red.findCoche(matricula));
        red.findCoche(matricula).setTaller(this);

        return true;
    }
}
