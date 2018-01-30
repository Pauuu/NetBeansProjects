package objetos;

import java.util.ArrayList;

public class Objetos {

    public static void main(String[] args) {
        
    }

    public class Libro {

        //Atributos
        private ArrayList<Pagina> paginas; //almacena objetos de tipo Pagina
        private String anyPublicacion;
        private String autor;

        //Metodos
        public void Llibro() {
        }

        public int getNumPagina() {
            return 0;
        }

        public void addPagina() {
            paginas.add(new Pagina(this, 5));
        }
    }

    public class Pagina {

        //atributos
        private Libro libro;
        private int numPag;

        //Metodos
        public Pagina(Libro l, int p) {
            this.libro = l;
            this.numPag = p;
        }

        public int getLibro() {
            return this.numPag;
        }
    }
    
    public class Biblioteca {
    
        //atributos
        private ArrayList <Libro> libros;
        private int totalLibros;
       
        
        
    
    
    }

}
