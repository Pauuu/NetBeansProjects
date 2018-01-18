package ejemplopoo;

import java.util.ArrayList;

public class Biblioteca {

    //ATRIBUTOS
    private ArrayList<Libros> libro;
    private String nombre;

    //METODOS
    public Biblioteca(String n) {
        this.nombre = n;
    }

    public void addLibro(int p, String a, String t) {
        this.libro.add(new Libros(p, a, t));
    }

    private void removeLibro() {

    }

    private void reportLibro() {

    }

}
