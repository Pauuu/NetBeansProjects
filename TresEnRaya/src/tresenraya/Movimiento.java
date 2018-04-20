package tresenraya;
/**
 * 
 * @author pau
 */

public class Movimiento {
    /**
     * Es una clase que solo contiene atributos. Da información sobre las
     * coordenadas del movimiento realizado y el tipo de ficha.
     */

    private int row;
    private int col;
    private boolean blancas;
    private Jugador jugador;

    public Movimiento(Jugador jugador, int fil, int col) {
        this.jugador = jugador;
        this.row = fil;
        this.col = col;
    }

    public int getFil() {
        return row;
    }

    public void setFil(int fil) {
        this.row = fil;
    }

    public int getCol() {
        return col;
    }

    public void setCol(int col) {
        this.col = col;
    }

    public boolean isBlancas() {
        return blancas;
    }

    public void setBlancas(boolean blancas) {
        this.blancas = blancas;
    }

    public Jugador getJugador() {
        return jugador;
    }

    public void setJugador(Jugador jugador) {
        this.jugador = jugador;
    }
    
    
}
