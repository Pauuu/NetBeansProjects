package ejemplopoo;

import java.util.ArrayList;

public class Pagina {

    //ATRIBUTOS
    private int numPag;
    private Libro libro;

    //METODOS
    public Pagina(Libro l, int n) {
        this.libro = l;
        this.numPag = n;
    }
    
    public Libro getLibro(){
        return this.libro;
    }
}
