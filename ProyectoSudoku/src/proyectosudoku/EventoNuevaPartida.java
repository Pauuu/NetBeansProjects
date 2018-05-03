package proyectosudoku;

import java.awt.event.*;

public class EventoNuevaPartida implements ActionListener {

    private Juego j;

    public EventoNuevaPartida(Juego juego) {
        j = juego;
    }

    public void actionPerformed(ActionEvent e) {

        int totalSudokus, id;

        Partida p = new Partida(j);
        Sudoku sk = new Sudoku();

        totalSudokus = sk.getListaSudokus().size();
        id = p.getJuego().getIdSudokuActual();

        if (id >= totalSudokus - 1) {
            id = 0;

        } else {
            id++;
        }

        p.getJuego().getSemaforo().cambioColor(1);
        p.setSudoku(sk.getValoresSudoku(id));

        j.setPartida(p);
        j.setIdSudokuActual(id);    //cambiar??
    }
}
