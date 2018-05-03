package proyectosudoku;

import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.*;

public class Tablero extends JPanel {

    private Casilla[][] casillas;
    private JPanel jpSudoku;
    private Partida partida;

    public Tablero(Partida p) {
        
        this.partida = p;

        casillas = new Casilla[9][9];
        jpSudoku = new JPanel(new GridLayout(9, 9));
        jpSudoku.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
    }

    public JPanel getJPanel() {
        return this.jpSudoku;
    }

    private void addCasillaFija(int valor, int fil, int col) {

        CasillaFija casillaF = new CasillaFija(Integer.toString(valor));

        casillas[fil][col] = casillaF;

        casillas[fil][col].setPosX(col);
        casillas[fil][col].setPosY(fil);
        casillas[fil][col].setValor(valor);

        casillas[fil][col].setTablero(this);

        jpSudoku.add(casillaF);
    }

    private void addCasillaVariable(int fil, int col) {

        CasillaVariable casillaV = new CasillaVariable("");
        EventoCasillaPulsada evento = new EventoCasillaPulsada();

        casillas[fil][col] = casillaV;

        casillas[fil][col].setPosX(col);
        casillas[fil][col].setPosY(fil);

        casillas[fil][col].addActionListener(evento);
        casillas[fil][col].setTablero(this);

        jpSudoku.add(casillaV);
    }

    //Setters & Getters
    public Casilla[][] getCasillas() {
        return this.casillas;
    }

    public int[][] getValoresCasillas() {

        int[][] valoresCasillas = new int[9][9];

        for (int fil = 0; fil < 9; fil++) {
            for (int col = 0; col < 9; col++) {
                valoresCasillas[fil][col] = this.getValorCasilla(fil, col);
            }
        }

        return valoresCasillas;
    }
    
    public Partida getPartida(){
        return this.partida;
    }

    public int getValorCasilla(int fil, int col) {
        return this.casillas[fil][col].getValor();
    }
    
    public void setPartida(Partida p){
        this.partida = p;
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
}
