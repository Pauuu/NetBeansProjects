package proyectosudoku;

import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.*;

public class Tablero extends JPanel {

    private Casilla[][] casilla;
    private JPanel jpSudoku;

    public Tablero() {

        casilla = new Casilla[9][9];
        jpSudoku = new JPanel(new GridLayout(9, 9));
        jpSudoku.setBorder(BorderFactory.createEmptyBorder(0, 10, 200, 30));
    }

    public JPanel getJPanel() {
        return this.jpSudoku;
    }

    public void comprobarValor() {

    }

    private void addCasillaFija(int valor, int fil, int col) {

        CasillaFija casillaF = new CasillaFija(Integer.toString(valor));
        
        casilla[fil][col] = casillaF;
        casilla[fil][col].setTablero(this);
        
        jpSudoku.add(casillaF);
    }

    private void addCasillaVariable(int fil, int col) {

        CasillaVariable casillaV = new CasillaVariable("");
        EventoCasillaPulsada evento = new EventoCasillaPulsada();

        casilla[fil][col] = casillaV;
        casilla[fil][col].addActionListener(evento);
        casilla[fil][col].setTablero(this);

        jpSudoku.add(casillaV);
    }

    //Setters & Getters
    public void setValores(int[][] valoresSudoku) {
        for (int fil = 0; fil < 9; fil++) {
            for (int col = 0; col < 9; col++) {

                if (valoresSudoku[fil][col] > 0) {
                    this.addCasillaFija(valoresSudoku[fil][col], fil, col);

                } else {
                    this.addCasillaVariable(fil, col);
                }
            }
        }
    }
}
