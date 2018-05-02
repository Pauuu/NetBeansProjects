package proyectosudoku;


import javax.swing.JButton;

public class Partida extends JButton {

    private Tablero tablero;

    //Constructor
    public Partida() {
        tablero = new Tablero();
        
    }

    //Públicos
    public void setSudoku(int[][] sudoku) {

        this.tablero.setValores(sudoku);
    }

    //Privados
    //Getters & Setters
    public Tablero getTablero() {
        return this.tablero;
    }
}
