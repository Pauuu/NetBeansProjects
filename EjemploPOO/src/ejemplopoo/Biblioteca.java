package ejemplopoo;

import java.util.ArrayList;

public class Biblioteca {

    //atributos
    private ArrayList<Libros> libro;
    private String nombre;

    //metodos
    public Biblioteca(String n) {
        this.nombre = n;
    }

    public void addLibro() {
        this.libro.add(new Libros());
    }

    private void removeLibro() {

    }

    private void reportLibro() {

    }
}
