package proyectosudoku;

import java.awt.*;
import javax.swing.*;

public class Juego extends JFrame {

    private Cronometro crono;
    private Semaforo semaforo;
    private Tablero teablero;

    public Juego() {
        super("Sudokus");
        this.mostrarVentana();
        this.iniciarPartida();
    }

    public void iniciarPartida() {
        Partida p = new Partida();

    }

    public void reiniciarPartida() {

    }

    public void mostrarVentana() {

        this.setSize(1200, 800);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Panel principal o MAIN
        JPanel mainPanel = new JPanel(new GridBagLayout());
        
        //PANEL SUDOKU
        JPanel jpSudoku = new JPanel(new GridLayout(9, 9));

        for (int boton = 0; boton < 81; boton++) {
            JButton b = new JButton();
            b.setP
            jpSudoku.add(new Button("··"));
        }

        mainPanel.add(jpSudoku);

        //PANEL INFO
        JPanel jpInfo = new JPanel(new GridBagLayout());
        JLabel jlCrono = new JLabel("00:00");
        
        jpInfo.add(jlCrono);
        mainPanel.add(jpInfo);
        
        //CONTAINER:
        Container cp = getContentPane();
        cp.add(mainPanel);

    }
}
