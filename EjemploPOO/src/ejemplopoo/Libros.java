package ejemplopoo;

import java.util.ArrayList;

public class Libros {

    //ATRIBUTOS
    private ArrayList<Paginas> pagina;
    private int numPag;
    private String autor;
    private String titulo;

    //METODOS
    public Libros(int totalPag, String a, String t) { //Añade libro(totalPaginaas, Autor, Título)
        numPag = totalPag;
        autor = a;
        titulo = t;
        
        //bucle que ejecuta addPagina tntas veces coo haga falta
        for (int i = 0; numPag < i; i++) {
            this.addPagina(new Paginas(this, i)); //   | lo de aqui abajo hace lo mismo que lo de arriba
            //this.pagina.add(new Paginas(this, i)); <-+
        }
    }

    private void addPagina(Paginas p) {
        this.pagina.add(p);
    }
}
