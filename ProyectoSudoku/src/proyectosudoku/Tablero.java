package proyectosudoku;

import java.awt.GridLayout;
import javax.swing.*;

public class Tablero extends JPanel {

    private Casilla[][] casilla;
    private JPanel jpSudoku;
    //private int[][] sudoku;

    public Tablero() {
        casilla = new Casilla[9][9];
        jpSudoku = new JPanel(new GridLayout(9, 9));

        //this.addCasillasFijas();
    }

    public JPanel getJPanel() {
        return this.jpSudoku;
    }

    /**
     * @deprecated no usar
     *
     * @param valoresSudoku
     */
    public void setValoresSudoku(int[][] valoresSudoku) {

        for (int fil = 0; fil < 9; fil++) {
            for (int col = 0; col < 9; col++) {

                if (valoresSudoku[fil][col] != 0) {
                    casilla[fil][col].setText(Integer.toString(valoresSudoku[fil][col]));
                }
            }
        }
    }

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

    private void addCasillaFija(int valor, int fil, int col) {

        CasillaFija casillaF = new CasillaFija(Integer.toString(valor));
        casilla[fil][col] = casillaF;
        jpSudoku.add(casillaF);
    }

    private void addCasillaVariable(int fil, int col) {
        
        CasillaVariable casillaV = new CasillaVariable("·");
        casilla[fil][col] = casillaV;
        jpSudoku.add(casillaV);
    }

    private void addCasillasVariables() {
        for (int fil = 0; fil < 9; fil++) {
            for (int col = 0; col < 9; col++) {

            }
        }
    }
}
