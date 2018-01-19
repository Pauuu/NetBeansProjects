package gestorPeliculas;

import java.util.*;

public class GestorPeliculas {

    //Atributos
    private ArrayList<Pelicula> peli;
    private int totalPelis;
    private String nameGestor;

    //metodos
    public static void main(String[] args) {
        GestorPeliculas g1 = new GestorPeliculas("Gestor 1");
        Pelicula uno = new Pelicula(1990, "Pau", "Evangelion");
        
        g1.addPelicula(uno);
        
    }
    
    public GestorPeliculas(String n){
        this.nameGestor = n;
    }
    
    public void addPelicula(Pelicula p){
        this.peli.add(p);
    }
    
}
