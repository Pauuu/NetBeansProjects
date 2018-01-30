package ejemplopoo;

import java.util.ArrayList;

public class Libro {

    //ATRIBUTOS
    private ArrayList<Pagina> pagina = new ArrayList<>();
    private int numPag;
    private String autor;
    private String titulo;

    //METODOS
    public Libro(int totalPag, String a, String t) { //Añade libro(totalPaginaas, Autor, Título)
        numPag = totalPag;
        autor = a;
        titulo = t;
        
        //bucle que ejecuta addPagina tntas veces coo haga falta
        for (int i = 0; numPag < i; i++) {
            this.addPagina(new Pagina(this, i)); //   | lo de aqui abajo hace lo mismo que lo de arriba
            //this.pagina.add(new Paginas(this, i)); <-+
        }
    }

    private void addPagina(Pagina p) {
        this.pagina.add(p);
    }
    
    public int getNumPag(){
        return this.numPag; 
    }
    
    public String getAutor(){
        return this.autor;
    }
    
    private String getTitulo(){
        return this.titulo;
    }
}
