package ejemplopoo;

import java.util.ArrayList;

public class Biblioteca {

    //ATRIBUTOS
    private ArrayList<Libro> libros = new ArrayList<>();
    private String nombre;

    //METODOS
    public Biblioteca(String n) {
        this.nombre = n;
    }

    public void addLibro(Libro l) {
        this.libros.add(l);
    }

    private void removeLibro() {

    }

    private void reportLibro() {        //lista de libros de la biblioteca
        for (int i = 0; libros.size() < i; i++) {
            System.out.println(libros.get(i));
        }
    }

    private String getBiblioteca() {
        return this.nombre;
    }

}
