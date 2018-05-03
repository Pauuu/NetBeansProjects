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

    public boolean validarMov() {

        int valoresCasillas[][];
        valoresCasillas = this.getValoresCasillas().clone();

        if (!this.validarCols(valoresCasillas)) {
            return false;

        } else if (!this.validarFils(valoresCasillas)) {
            return false;

        } else if (!this.validarSectores(valoresCasillas)) {
            return false;

        } else {
            return true;
        }
    }

    public boolean validarVictoria() {

        int valoresCasillas[][];
        int total;

        valoresCasillas = this.getValoresCasillas().clone();

        for (int fil = 0; fil < 9; fil++) {

            total = 0;
            for (int col = 0; col < 9; col++) {
                total = total + valoresCasillas[fil][col];
            }

            if (total != 45) {
                return false;
            }
        }

        return true;
    }

    private boolean comprobarValores(int valores[]) {

        for (int num = 0; num < 8; num++) {
            if (valores[num] != 0) {

                for (int pivote = num + 1; pivote < 9; pivote++) {
                    if (valores[pivote] != 0) {

                        if (valores[num] == valores[pivote]) {
                            return false;
                        }
                    }
                }
            }
        }

        return true;
    }

    private boolean validarCols(int[][] valoresCasillas) {

        int valores[] = new int[9];

        //valida todas las filas:
        for (int fil = 0; fil < 9; fil++) {
            for (int col = 0; col < 9; col++) {
                valores[col] = valoresCasillas[fil][col];
            }

            // si jugador comete un error:
            if (!this.comprobarValores(valores)) {
                return false;    //=================no validado===============>>
            }
        }
        return true;
    }

    private boolean validarFils(int[][] valoresCasillas) {

        int valores[] = new int[9];

        //valida todas las columnas:
        for (int col = 0; col < 9; col++) {
            for (int fil = 0; fil < 9; fil++) {
                valores[fil] = valoresCasillas[fil][col];
            }

            // si jugador comete un error:
            if (!this.comprobarValores(valores)) {
                return false;    //=================no validado===============>>
            }
        }

        return true;
    }

    private boolean validarSectores(int[][] valoresCasillas) {

        int[] valores = new int[9];

        for (int sectorX = 0; sectorX < 3; sectorX++) {
            for (int sectorY = 0; sectorY < 3; sectorY++) {

                int pos = 0;

                for (int fil = sectorX * 3; fil < (sectorX * 3) + 3; fil++) {
                    for (int col = sectorY * 3; col < (sectorY * 3) + 3; col++) {

                        valores[pos] = valoresCasillas[fil][col];
                        pos++;
                    }
                }

                // si hay un error:
                if (!this.comprobarValores(valores)) {
                    return false;   //===============no validado==============>>
                }
            }
        }

        return true;
    }

    private void addCasillaFija(int valor, int fil, int col) {

        CasillaFija casillaF = new CasillaFija(Integer.toString(valor));

        casillas[fil][col] = casillaF;

        casillas[fil][col].setValor(valor);
        casillas[fil][col].setTablero(this);

        jpSudoku.add(casillaF);
    }

    private void addCasillaVariable(int fil, int col) {

        CasillaVariable casillaV = new CasillaVariable("");
        EventoCasillaPulsada evento = new EventoCasillaPulsada();

        casillas[fil][col] = casillaV;

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

    public Partida getPartida() {
        return this.partida;
    }

    public int getValorCasilla(int fil, int col) {
        return this.casillas[fil][col].getValor();
    }

    public void setPartida(Partida p) {
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
