package proyectosudoku;

import java.awt.*;
import javax.swing.*;

public class Juego extends JFrame {

    private Partida partida;
    private Semaforo semaforo;

    public Juego() {
        super("Proyecto Sudoku");

        this.mostrarVentana();
       
    }


    public void mostrarVentana() {

        this.setSize(1200, 800);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container cp = getContentPane();

        //Panel principal o MAIN
        JPanel mainPanel = new JPanel(new GridBagLayout());
        
        //NUEVA PARTIDA
        this.mostrarTablero(mainPanel);
        
        //BOTON NUEVA PARTIDA
        //this.botonNuevaPartida(mainPanel);

        //SEMAFORO
        //this.mostrarSemaforo(mainPanel);

        
        //PANEL 
        cp.add(mainPanel);

    }

    private void mostrarTablero(JPanel mainPanel) {
        partida = new Partida(mainPanel);
    }

    private void botonNuevaPartida(JPanel mainPanel) {
        JButton nuevaPartida = new JButton("Nueva Partida");

        GridBagConstraints c = new GridBagConstraints();
        c.gridx = 1;
        c.gridy = 0;

        mainPanel.add(nuevaPartida, c);
    }

    private void mostrarSemaforo(JPanel mainPanel) {
        JLabel imgSemaforo = new JLabel("Semaforo");

        GridBagConstraints c = new GridBagConstraints();
        c.gridx = 1;
        c.gridy = 1;

        mainPanel.add(imgSemaforo, c);
    }


}
