package proyectosudoku;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JButton;
import javax.swing.JTextField;

public class Casilla extends JButton {

    private Tablero tablero;
    private int valor;

    public Casilla() {

        this.setPreferredSize(new Dimension(60, 60));
    }

    public Casilla getCasilla(int fila, int col) {
        return this;
    }

    public int getValor(int fila, int col) {
        return this.valor;
    }
    
    public Tablero getTablero(){
        return this.tablero;
    }
    
    public void setTablero(Tablero t){
        this.tablero = t;
    }

    public void setValor(int val) {
        this.valor = val;
    }
}
