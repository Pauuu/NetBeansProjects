package poomariaadrover;

import java.util.*;

public class RedBibliotecas {

    private ArrayList<Biblioteca> redBiblioteca;

    private RedBibliotecas() {
        this.redBiblioteca = new ArrayList();
    }

    public void addBiblioteca(Biblioteca biblioteca) {
        this.redBiblioteca.add(biblioteca);
    }

    // Cambiar un libro a otra biblioteca
    public void moverLibro(Libro l, Biblioteca b2) {
        (l.getBiblioteca()).removeLibro(l);     //si quitamos los parentesis no saldria igual
        b2.addLibro(l);

        /* hace lo mismo que lo de arriba
        Biblioteca bSource;
        
        bSource = l.getBiblioteca();
        bSource = removeLibro(l);
        bTarget.addlibro(l);     
         */
    }

    public void reportBiblioteca(Biblioteca b) {
        System.out.println("Biblioteca " + b.getNombreBiblio());
        System.out.println("================");
        System.out.println("* Esta biblioteca tiene <" + b.stockBiblioteca() + "> libros.");

        b.reportLibros();
        System.out.println();
    }

    public static void main(String[] args) {

        // Crear redBibliotecas
        RedBibliotecas red1 = new RedBibliotecas();

        // Crear bibliotecas
        Biblioteca biblioteca1 = new Biblioteca("Plaza");
        Biblioteca biblioteca2 = new Biblioteca("Real");

        // Añadir bibliotecas a la red
        red1.addBiblioteca(biblioteca1);
        red1.addBiblioteca(biblioteca2);

        // Crear libros
        Libro libro1 = new Libro("Pepe Gotera 1", "Asimov1", "2000", 876);
        Libro libro2 = new Libro("Pepe Gotera 2", "Asimov2", "2001", 500);
        Libro libro3 = new Libro("Pepe Gotera 3", "Asimov3", "1999", 298);
        Libro libro4 = new Libro("Pepe Gotera 4", "Mann", "2017", 76);
        Libro libro5 = new Libro("Pepe Gotera 5", "Mann", "2018", 150);

        // Añadir libros a la bibilioteca  1-3 a biblioteca1, 4-5 a biblioteca 2
        biblioteca1.addLibro(libro1);
        biblioteca1.addLibro(libro2);
        biblioteca1.addLibro(libro3);
        biblioteca2.addLibro(libro4);
        biblioteca2.addLibro(libro5);

        // Listado libros bibliotecas
        red1.reportBiblioteca(biblioteca1);
        red1.reportBiblioteca(biblioteca2);

        System.out.println();

        // Prueba métodos moverLibro
        red1.moverLibro(libro2, biblioteca2);
        red1.moverLibro(libro3, biblioteca2);

        System.out.println("------------------------------------------------------------");
        System.out.println("Prueba de mover libros entre bibliotecas");
        System.out.println("Los libros 2 y 3 se cambian de la biblioteca Plaza a la Real");
        System.out.println("------------------------------------------------------------");
        System.out.println();
        // Listado libros bibliotecas
        red1.reportBiblioteca(biblioteca1);
        red1.reportBiblioteca(biblioteca2);
    }
}


/*package biblioteca;
 
import java.util.*;
 
public class RedBibliotecas {
 
    private ArrayList<Biblioteca> redBiblioteca;
 
    private RedBibliotecas() {
        this.redBiblioteca = new ArrayList();
    }
 
    public void addBiblioteca(Biblioteca biblioteca) {
        this.redBiblioteca.add(biblioteca);
    }
 
    // Cambiar un libro a otra biblioteca
    public void moverLibro(Libro l, Biblioteca b2) {
        (l.getBiblioteca()).removeLibro(l);
        b2.addLibro(l);
    }
 
    public void reportBiblioteca(Biblioteca b) {
        System.out.println("Biblioteca " + b.getNombreBiblio());
        System.out.println("================");
        System.out.println("* Esta biblioteca tiene <" + b.stockBiblioteca() + "> libros.");
 
        b.reportLibros();
        System.out.println();
    }
 
    public static void main(String[] args) {
        String nombreBiblioteca;
 
        // Crear redBibliotecas
        RedBibliotecas red1 = new RedBibliotecas();
 
        // Crear bibliotecas
        Biblioteca biblioteca1 = new Biblioteca("Plaza");
        Biblioteca biblioteca2 = new Biblioteca("Real");
 
        // Añadir bibliotecas a la red
        red1.addBiblioteca(biblioteca1);
        red1.addBiblioteca(biblioteca2);
 
        // Crear libros
        Libro libro1 = new Libro("Pepe Gotera1", "Asimov1", "2000", 876);
        Libro libro2 = new Libro("Pepe Gotera 2", "Asimov2", "2001", 500);
        Libro libro3 = new Libro("Pepe Gotera 3", "Asimov3", "1999", 298);
        Libro libro4 = new Libro("Pepe Gotera 4", "Mann", "2017", 76);
        Libro libro5 = new Libro("Pepe Gotera 5", "Mann", "2018", 150);
 
        // Añadir libros a la bibilioteca
        biblioteca1.addLibro(libro1);
        biblioteca1.addLibro(libro2);
        biblioteca1.addLibro(libro3);
        biblioteca2.addLibro(libro4);
        biblioteca2.addLibro(libro5);
 
        // Listado libros bibliotecas
        red1.reportBiblioteca(biblioteca1);
        red1.reportBiblioteca(biblioteca2);
 
        System.out.println();
 
        // Prueba métodos moverLibro
        red1.moverLibro(libro2, biblioteca2);
        red1.moverLibro(libro3, biblioteca2);
 
        System.out.println("------------------------------------------------------------");
        System.out.println("Prueba de mover libros entre bibliotecas");
        System.out.println("Los libros 2 y 3 se cambian de la biblioteca Plaza a la Real");
        System.out.println("------------------------------------------------------------");
        System.out.println();
        // Listado libros bibliotecas
        red1.reportBiblioteca(biblioteca1);
        red1.reportBiblioteca(biblioteca2);
    }
}
 
// *******************************************************************************************************
 
 
 
package biblioteca;
 
import java.util.ArrayList;
 
public class Biblioteca {
 
    private ArrayList<Libro> libros;
    private String nombreBiblioteca;
 
    public Biblioteca(String nombreBiblioteca) {
        this.nombreBiblioteca = nombreBiblioteca;
        this.libros = new ArrayList();
    }
 
    // Publicos ----------------------------------------------------------------
    //
    public void addLibro(Libro l) {
        this.libros.add(l);
        l.setBiblioteca(this);  // Supongo que no hace falta ponerlo en el constructor
    }
 
    public String getNombreBiblio() {
        return this.nombreBiblioteca;
    }
 
    // Quitar un libro de una biblioteca
    public void removeLibro(Libro l) {
        this.libros.remove(l);
        l.removeBiblioteca(); // Se pone null, o sea, que el libro no esté en ninguna biblioteca
    }
 
    // Información de los libros de la biblioteca: título, año y autor
    public void reportLibros() {
        System.out.println("* Listado de libros");
 
        for (int i = 0; i < this.libros.size(); i++) {
            System.out.println("  Libro num <" + (i + 1)
                    + ">  Título: " + (libros.get(i).getTitulo()) + "  "
                    + "Autor: " + (libros.get(i).getAutor()) + "  "
                    + "Año de publicación: " + (libros.get(i).getAny()));
 
        }
    }
 
    public int stockBiblioteca() {
        return this.libros.size();
    }
}
 
// *******************************************************************************************************
 
 
 
package biblioteca;
 
import java.util.ArrayList;
 
public class Libro {
 
    private ArrayList<Pagina> paginas;
    private Biblioteca biblioteca;
    private String autor;
    private String titulo;
    private String year;
 
    public Libro(String titulo, String autor, String year, int numPaginas) {
        this.titulo = titulo;
        this.autor = autor;
        this.year = year;
        this.paginas = new ArrayList();
 
        // Crear las paginas del libro
        for (int i = 1; i <= numPaginas; i++) {
            this.addPagina(new Pagina(this, i));
        }
    }
 
    // Publicos ----------------------------------------------------------------
    //
    public String getAny() {
        return this.year;
    }
 
    public String getAutor() {
        return this.autor;
    }
 
    public Biblioteca getBiblioteca() {
        return this.biblioteca;
    }
 
    public String getTitulo() {
        return this.titulo;
    }
 
    public void removeBiblioteca() {
        this.biblioteca = null;
    }
 
    public void setBiblioteca(Biblioteca b) {
        if (b != null) {
            this.biblioteca = b;
        }
    }
 
    // Privados ----------------------------------------------------------------
    //
    // método private porque no tiene sentido añadir páginas si no es al crear un libro
    private void addPagina(Pagina p) {
        this.paginas.add(p);
    }
 
}
 
// *******************************************************************************************************
 
 
package biblioteca;
 
public class Pagina {
   
    private int numero;
    private Libro libro;
 
    public Pagina(Libro libro, int numero) {
        this.libro = libro;
        this.numero = numero;
    }
}*/
