package tresenraya;

public class Partida {

    //ATRIBUTOS
    private Jugador jugadorActual;
    private Tablero tablero;

    //METODOS
    //Publicos
    public Partida() {
        crearTablero();
    }

    public void jugar() {

    }

    //Privados
    private void crearTablero() {
        Tablero t = new Tablero();
        this.setTablero(t);
    }

    //GETTERS / SETTERS
    public Jugador getJugadorActual() {
        return jugadorActual;
    }

    public void setJugadorActual(Jugador jugadorActual) {
        this.jugadorActual = jugadorActual;
    }

    public Tablero getTablero() {
        return tablero;
    }

    public void setTablero(Tablero tablero) {
        this.tablero = tablero;
    }

}
