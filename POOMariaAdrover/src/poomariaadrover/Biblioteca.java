package poomariaadrover;

import java.util.ArrayList;

public class Biblioteca {

    private ArrayList<Libro> libros;
    private String nombreBiblioteca;

    //CONSTRUCTOR   
    public Biblioteca(String nombreBiblioteca) {    //[TRADUCCION DEL UML]: aqui solo ponemos el nombre sin los libros, pq los libros los añadimos despues; una biblioteca puede estar sin libros; los libros se pueden mover de una biblioteca a otra
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
                    + ">  Título: " + (this.libros.get(i).getTitulo()) + "  "
                    + "Autor: " + (this.libros.get(i).getAutor()) + "  "
                    + "Año de publicación: " + (this.libros.get(i).getAny()));
        }
    }

    public int stockBiblioteca() {
        return this.libros.size();
    }
}
