package proyectosudoku;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JPanel;

public class Partida {

    private Tablero tablero;
    private int[][] sudoku;

    public Partida(JPanel mainPanel) {
        tablero = new Tablero();
        
        this.cargarTableroGrafico(mainPanel);
        this.cargarSudoku(0);
       
    }

    public void cargarSudoku(int id) {
        Sudoku sk = new Sudoku();
        this.tablero.setValoresSudoku(sk.getValoresSudoku(id));

        //this.pasarNumerosFijos(enunciadoSudoku);
    }

    private void cargarTableroGrafico(JPanel mainPanel) {

        GridBagConstraints c = new GridBagConstraints();
        //c.gridx = 0;
        //c.gridy = 0;
        c.gridheight = 1000;
        c.gridwidth = 1000;
        c.fill = GridBagConstraints.BOTH;
        c.weightx = 1;
        c.weighty = 1;
        //c.insets = new Insets(2, 2, 2, 2);

        mainPanel.add(tablero.getJPanel(), c);
    }

    /*
    private void pasarNumerosFijos(int[][] enunciadoSudoku) {
        this.tablero.setSudoku();
    }
     */
}
