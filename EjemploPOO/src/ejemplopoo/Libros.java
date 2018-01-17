package ejemplopoo;

import java.util.ArrayList;

public class Libros {

    //atributos
    private ArrayList<Paginas> pagina;
    private int numPag;
    private String autor;
    private String titulo;

    //metodos
    public Libros(int totalpaginas, String a, String t) {
        //bucle que ejecure addPagina tntas veces coo haga falta
        for(int i = 0;;){
            this.addPagina(new Paginas(this, i));
        }
    }

    private void addPagina(Paginas p) {
        this.pagina.add(p);
    }
}
