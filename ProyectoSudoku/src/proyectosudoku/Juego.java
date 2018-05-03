package proyectosudoku;

import java.awt.*;
import java.util.Scanner;
import javax.swing.*;

public class Juego extends JFrame {

    private JPanel panel, panelTablero;
    private Partida partida;
    private Semaforo semaforo;
    private int idSudokuActual;

    public Juego() {
        super("Proyecto Sudoku");

        this.nuevaPartida(0);
        this.mostrarVentana();
    }

    public void mostrarVentana() {

        this.setSize(1000, 700);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container cp = getContentPane();

        //Panel principal o MAIN
        panel = new JPanel(new GridBagLayout());

        //NUEVA PARTIDA
        this.mostrarTablero(panel);

        //BOTON NUEVA PARTIDA
        this.botonNuevaPartida(panel);

        //SEMAFORO
        this.mostrarSemaforo(panel);

        //PANEL 
        cp.add(panel);
    }

    private void botonNuevaPartida(JPanel mainPanel) {
        JButton jbNuevaPartida = new JButton("Nueva Partida");

        GridBagConstraints c = new GridBagConstraints();
        c.gridx = 1;
        c.gridy = 0;
        c.ipadx = 200;
        c.ipady = 50;
        c.insets = new Insets(-450, 0, 0, 0);

        mainPanel.add(jbNuevaPartida, c);

        EventoNuevaPartida evento = new EventoNuevaPartida(this);
        jbNuevaPartida.addActionListener(evento);

    }

    private void mostrarSemaforo(JPanel mainPanel) {

        JPanel imgSemaforo = new JPanel(new GridLayout(1, 1));
        semaforo = new Semaforo();

        imgSemaforo.add(semaforo);

        GridBagConstraints c = new GridBagConstraints();
        c.gridx = 1;
        c.gridy = 1;
        c.insets = new Insets(-500, 0, 00, 0);

        mainPanel.add(imgSemaforo, c);
    }

    private void mostrarTablero(JPanel mainPanel) {

        panelTablero = partida.getTablero().getJPanel();

        GridBagConstraints c = new GridBagConstraints();
        c.gridx = 0;
        c.gridy = 0;
        c.gridheight = 1;
        c.gridwidth = 1;
        c.fill = GridBagConstraints.BOTH;

        mainPanel.add(panelTablero, c);
    }

    public void nuevaPartida(int id) {

        partida = new Partida(this);
        Sudoku sk = new Sudoku();

        this.idSudokuActual = id;
        
        partida.setSudoku(sk.getValoresSudoku(idSudokuActual));
    }

    //Getters & Setters
    public Partida getPartida() {
        return this.partida;
    }

    public Semaforo getSemaforo() {
        return this.semaforo;
    }
    
    public int getIdSudokuActual(){
        return this.idSudokuActual;
    }
    
    public void setIdSudokuActual(int id){
        this.idSudokuActual = id;
    }

    public void setPartida(Partida p) {

        this.panel.remove(panelTablero);
        this.partida = p;

        this.mostrarTablero(panel);
        this.revalidate();
        this.repaint();
    }
}
