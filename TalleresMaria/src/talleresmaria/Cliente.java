/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package talleresmaria;


import java.util.ArrayList;
 
public class Cliente {
 
    private ArrayList<Coche> misCoches;
    private int telefono;
    private RedTalleresMaria red;
    private String dni;
    private String fechaAlta;
    private String nombre;
 
    public Cliente(RedTalleresMaria r, String dni, String nombre, int telefono) {
        this.red = r;
        this.dni = dni;
        this.nombre = nombre;
        this.telefono = telefono;
        this.misCoches = new ArrayList();
    }
 
    public boolean addCoche(String matricula) {
        Coche c = this.red.findCoche(matricula);
 
        if (c == null) {
            System.out.println("El coche con matrícula " + matricula + " no se encuentra en nuestra base de datos.");
            return false; // ====== El coche NO existe en la BD de la red =====>
        }
 
        // Comprobar que el coche no esta ya añadido
        if (this.findCoche(matricula) != null) {
            return false; // ==== El vehiculo ya es propiedad del cliente =====>        
        }
 
        this.misCoches.add(c);
        c.setPropietario(this);
 
        return true; // Añadido correctamente
    }
 
    public Coche findCoche(String matricula) {
        for (int i = 0; i < this.misCoches.size(); i++) {
            if (this.misCoches.get(i).getMatricula().equalsIgnoreCase(matricula)) {
                return this.misCoches.get(i); // ====== encontrado Coche ======>
            }
        }
 
        return null; // ==========coche NO encontrado =========================>
    }
 
    public String getDni() {
        return this.dni;
    }
 
    public String getFecha() {
        return this.fechaAlta;
    }
 
    public String getNombre() {
        return this.nombre;
    }
 
    public RedTalleresMaria getRed() {
        return this.red;
    }
 
    public int getTelefono() {
        return this.telefono;
    }
 
    public void infoCliente() {
        System.out.println("----------------");
        System.out.println("Ficha de cliente");
        System.out.println("----------------");
        System.out.println("DNI: " + this.getDni());
        System.out.println("Nombre: " + this.getNombre());
        System.out.println("Teléfono: " + this.getTelefono());
        System.out.println("Fecha de alta: " + this.getFecha());
 
        if (!this.misCoches.isEmpty()) {
            for (int n = 0; n < misCoches.size(); n++) {
                System.out.println("");
                System.out.println("VEHÍCULO " + (n + 1) + ": " + (misCoches.get(n)).getMarca() + "  " + (misCoches.get(n)).getModelo());
                System.out.println("Matrícula: " + (misCoches.get(n)).getMatricula());
 
                if ((misCoches.get(n)).getTaller() != null) {
                    System.out.println("EN REPARACIÓN en el taller " + ((misCoches.get(n)).getTaller()).getNombre());
                }
            }
        } else {
            System.out.println("Este cliente no tiene ningún vehículo.");
        }
    }
 
    public boolean removeCoche(String matricula) {
       if (this.findCoche(matricula) == null) {
           return false; // ===================================================>
       }
       
        this.findCoche(matricula).setPropietario(null);
        this.misCoches.remove(this.findCoche(matricula));
       
        return true;
    }
 
    public void setFecha(String f) {
        this.fechaAlta = f;
    }
}
