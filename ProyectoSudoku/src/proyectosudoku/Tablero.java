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

        for (int fil = 0; fil < 9; fil++) {
            for (int col = 0; col < 9; col++) {
                
                Casilla b = new Casilla("·");
                casilla[fil][col] = b;
                
                jpSudoku.add(b);
            }
        }
    }

    public JPanel getJPanel() {
        return this.jpSudoku;
    }
    
    
}
