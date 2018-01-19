package poomariaadrover;

import java.util.ArrayList;

public class Libro {

    private ArrayList<Pagina> paginas;
    private Biblioteca biblioteca;
    private String autor;
    private String titulo;
    private String year;

    public Libro(String titulo, String autor, String year, int numPaginas) {    //[TRADUCCION DEL UML]: al crear el libro se crean con las paginas si o si, y ademas creamos el numero de objetos Pagina deseado
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
