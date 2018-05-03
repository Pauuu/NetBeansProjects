package proyectosudoku;

import java.awt.event.*;
import javax.swing.JFrame;

public class EventoNuevaPartida implements ActionListener {

    private Juego j;

    public EventoNuevaPartida(Juego juego) {
        j = juego;
    }

    public void actionPerformed(ActionEvent e) {
        System.out.println("caca");

        Partida p = new Partida(j);
        p.getJuego().getSemaforo().cambioColor(1);
        Sudoku sk = new Sudoku();
        

        int id = (int) (Math.random() * 2);
        
        p.setSudoku(sk.getValoresSudoku(id));

        j.setPartida(p);
    }
}
