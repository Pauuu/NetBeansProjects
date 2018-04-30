package proyectosudoku;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JButton;
import javax.swing.JTextField;

public class Casilla extends JTextField {

    private boolean valValido;
    private int valor;

    public Casilla() {
        
        this.setPreferredSize(new Dimension(100, 100));
    }

    public int getValor(int fila, int col) {
        return valor;
    }

    public void setValor(int val) {
        this.valor = val;
    }

    public Casilla getCasilla(int fila, int col) {
        return this;
    }
}
