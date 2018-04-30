package proyectosudoku;

import java.awt.GridLayout;
import javax.swing.*;

public class Tablero extends JPanel {

    private CasillaFija[][] casillaFija;
    private JPanel jpSudoku;
    //private int[][] sudoku;

    public Tablero() {
        casillaFija = new CasillaFija[9][9];
        jpSudoku = new JPanel(new GridLayout(9, 9));

        //this.addCasillasFijas();
    }

    public JPanel getJPanel() {
        return this.jpSudoku;
    }

    public void setValoresSudoku(int[][] valoresSudoku) {

        for (int fil = 0; fil < 9; fil++) {
            for (int col = 0; col < 9; col++) {

                if (valoresSudoku[fil][col] != 0) {
                    casillaFija[fil][col].setText(Integer.toString(valoresSudoku[fil][col]));
                }
            }
        }
    }

    private void addCasillasFijas(int[][] valoresSudoku) {
        for (int fil = 0; fil < 9; fil++) {
            for (int col = 0; col < 9; col++) {
                
                 if (valoresSudoku[fil][col] != 0) {
                     
                     CasillaFija casilla = new CasillaFija(Integer.toString(valoresSudoku[fil][col]));
                     casillaFija[fil][col] = casilla;
                     jpSudoku.add(casilla);
                 }
            }
        }
    }
}
