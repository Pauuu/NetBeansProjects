package proyectosudoku;

import javax.swing.JButton;

public class Partida extends JButton {

    private Juego juego;
    private Tablero tablero;

    //Constructor
    public Partida(Juego j) {
        this.juego = j;
        this.tablero = new Tablero(this);
    }

    //Públicos
    public void setSudoku(int[][] sudoku) {

        this.tablero.setValores(sudoku);
    }

    public Tablero getTablero() {
        return this.tablero;
    }

    public Juego getJuego() {
        return this.juego;
    }
}
