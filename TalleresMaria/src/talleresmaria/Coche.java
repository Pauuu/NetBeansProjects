/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package talleresmaria;


public class Coche {
 
    private Cliente propietario;
    private int km;
    private RedTalleresMaria red;
    private String color;
    private String marca;
    private String matricula;
    private String modelo;
    private Taller taller;
 
    public Coche(RedTalleresMaria r, int km, String color, String marca, String matricula, String modelo) {
        this.red = r;
        this.km = km;
        this.color = color;
        this.marca = marca;
        this.matricula = matricula;
        this.modelo = modelo;
    }
 
    public String getColor() {
        return this.color;
    }
 
    public int getKm() {
        return this.km;
    }
 
    public String getMarca() {
        return this.marca;
    }
 
    public String getMatricula() {
        return this.matricula;
    }
 
    public String getModelo() {
        return this.modelo;
    }
 
    public Cliente getPropietario() {
        return this.propietario;
    }
 
    public RedTalleresMaria getRed() {
        return this.red;
    }
 
    public Taller getTaller() {
        return this.taller;
    }
 
    public void infoCoche() {
        System.out.println("-----------------");
        System.out.println("Ficha de vehículo");
        System.out.println("-----------------");
        System.out.println("Matrícula: " + this.getMatricula());
        System.out.println("Marca: " + this.getMarca());
        System.out.println("Modelo: " + this.getModelo());
        System.out.println("Color: " + this.getColor());
        System.out.println("Kilómetros: " + this.getKm());
        System.out.println("Propietario " + (this.getPropietario()).getNombre() + " - DNI: " + (this.getPropietario()).getDni());
        System.out.println("");
        if (this.getTaller() != null) {
            System.out.println("*** EN REPARACIÓN ***");
            System.out.println("Taller: " + (this.getTaller()).getNombre() + " - CÓDIGO Taller: " + (this.getTaller()).getCodigo());
        } else {
            System.out.println("EL VEHÍCULO NO ESTÁ EN REPARACIÓN");
        }
    }
 
    public void setPropietario(Cliente p) {
        this.propietario = p;
    }
 
    public void setTaller(Taller t) {
        this.taller = t;
    }
 
}