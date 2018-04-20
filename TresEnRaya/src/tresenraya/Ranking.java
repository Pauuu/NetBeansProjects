package tresenraya;

/**
 *
 * @author pau
 */
public class Ranking {

    private int partidasJugadas;
    private int empates;
    private int ganadasHumano;

    public Ranking() {
        super();
    }

    public void ganar() {
        this.partidasJugadas++;
        this.ganadasHumano++;
    }

    public void empatar() {
        this.partidasJugadas++;
        this.empates++;
    }

    public void mostrar() {
        System.out.println("Partidas jugadas:" + partidasJugadas);
        System.out.println("empates: " + empates);
        System.out.println("Partidas ganadas: " + ganadasHumano);
    }

    private void ganador() {

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
