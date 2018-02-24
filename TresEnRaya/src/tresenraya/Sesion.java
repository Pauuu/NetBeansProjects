package tresenraya;

public class Sesion {
    
    //MAIN

    public static void main(String[] args) {
        Sesion s = new Sesion("f");
    }

    //ATRIBUTOS
    
    private int horaInici;
    private Jugador[] jugador = new Jugador[2];
    private Partida partida;
    private Ranking ranking;
    
    //MÉTODOS

    public Sesion(String nombre) {

        crearPartida();
        crearRanking();
        crearJugador(nombre);

    }

    public void crearJugador(String nombre) {
        jugador[0] = new Jugador(nombre);
    }

    public void crearPartida() {
        Partida p = new Partida();
        this.setPartida(p);
    }

    public void crearRanking() {
        Ranking r = new Ranking();
        this.setRanking(r);
    }

    public void crearHumano() {
        // TODO implement me    
    }

    public void mostrarRanking() {
        // TODO implement me    
    }

    public void menu() {
        // TODO implement me    
    }

    public int sorteoTurno() {

        return (int) (Math.random() * 2);   //0 cara; 1 cruz

    }

    //GETTES / SETTERS
    
    public int getHoraInici() {
        return horaInici;
    }

    public void setHoraInici(int horaInici) {
        this.horaInici = horaInici;
    }

    public Jugador[] getJugador() {
        return jugador;
    }

    public void setJugador(Jugador[] jugador) {
        this.jugador = jugador;
    }

    public Partida getPartida() {
        return partida;
    }

    public void setPartida(Partida partida) {
        this.partida = partida;
    }

    public Ranking getRanking() {
        return ranking;
    }

    public void setRanking(Ranking ranking) {
        this.ranking = ranking;
    }

}
