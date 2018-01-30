package ejemplopoo;

import java.util.ArrayList;

public class GestorBibliotecas {

    public static void main(String[] args) {

        test();
        
    }

    //ATRIBUTOS
    private ArrayList<Biblioteca> biblioteca = new ArrayList<>();

    //METODOS
    private void addBiblioteca(String b) {
        this.biblioteca.add(new Biblioteca(b));
    }

    private void moverLibro() {      //devolver libro(?)

    }

    private static void test() {
        Libro m;
        m = new Libro(3, "Eustaquio", "Matemáticas"); //ejemplo

        Biblioteca biblio = new Biblioteca("Biblio");
        addBiblioteca("hola");
    }
}
