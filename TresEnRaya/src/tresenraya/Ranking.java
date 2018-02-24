package tresenraya ;


public class Ranking {
    
    private int partidasJugadas;    
    private int empates;    
    private int ganadasHumano; 
 
    public Ranking(){
        super();
    }
    
    public void empatar() {
        // TODO implement me    
    }
    
    public void ganar() {
        // TODO implement me    
    }
    
    public void mostrar() {
        // TODO implement me    
    }
    
    //GETTERS / SETTERS

    public int getPartidasJugadas() {
        return partidasJugadas;
    }

    public void setPartidasJugadas(int partidasJugadas) {
        this.partidasJugadas = partidasJugadas;
    }

    public int getEmpates() {
        return empates;
    }

    public void setEmpates(int empates) {
        this.empates = empates;
    }

    public int getGanadasHumano() {
        return ganadasHumano;
    }

    public void setGanadasHumano(int ganadasHumano) {
        this.ganadasHumano = ganadasHumano;
    }
    
}
