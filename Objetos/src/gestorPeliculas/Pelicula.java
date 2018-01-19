package gestorPeliculas;

public class Pelicula {
    //atributos
    private int anyo;
    private String director;
    private String titulo;
    
    //metodos
    public Pelicula(int a, String d, String t){
        this.anyo = a;
        this.director = d;
        this.titulo = t;
    }
    
    public int getAnyo(){
        return this.anyo;
    }
    
    public String getDirector(){
        return this.director;
    }
    
    public String getTitulo(){
        return this.titulo;
    }
}
