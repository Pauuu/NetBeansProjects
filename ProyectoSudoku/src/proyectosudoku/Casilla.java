package proyectosudoku;

import javax.swing.JButton;

public class Casilla extends JButton {

    private boolean valValido;
    private int valor;

    public Casilla(String str) {
        this.setText(str);
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
