package redcentros;

public class Asignatura {
    
    //ATRIBUTOS
    private int nivell;
    private String denominacion;
    
    //METODOS
    public Asignatura(int nivell, String denominacion){
        this.nivell = nivell;
        this.denominacion = denominacion;
    }

    public int getNivell() {
        return nivell;
    }

    public void setNivell(int nivell) {
        this.nivell = nivell;
    }

    public String getDenominacion() {
        return denominacion;
    }

    public void setDenominacion(String denominacion) {
        this.denominacion = denominacion;
    }
    
    
}
