package proyectosudoku;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JPanel;

public class Partida {

    private Tablero tablero;
    private int[][] sudoku;

    public Partida(JPanel mainPanel) {
        tablero = new Tablero();

        GridBagConstraints c = new GridBagConstraints();

        c.gridx = 0;
        c.gridy = 0;
        c.insets = new Insets(2, 2, 2, 200);

        mainPanel.add(tablero.getJPanel(), c);
    }
}
