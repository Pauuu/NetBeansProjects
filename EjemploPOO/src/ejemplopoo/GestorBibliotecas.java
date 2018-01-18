package ejemplopoo;

import java.util.ArrayList;

public class GestorBibliotecas {

    public static void main(String[] args) {
        Libros a = new Libros(3,"d","e");   //ejemplo
        
        //this.addBiblioteca("d");
       
    }
    
    //ATRIBUTOS
    private ArrayList<Biblioteca> biblioteca;

    
    //METODOS
    private void addBiblioteca(String b) {
        this.biblioteca.add(new Biblioteca(b));
    }

    private void moverLibro() {      //devolver libro(?)
        
    }
    
    private void abc(){

    }

}
