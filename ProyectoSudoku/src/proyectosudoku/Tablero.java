package proyectosudoku;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Tablero extends JPanel implements ActionListener {

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

        if (!this.validarFils()) {
            return false;

        } else if (!this.validarCols()) {
            return false;

        } else if (!this.validarSectores()) {
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

    private boolean comprobarRepetido(int valores[]) {

        boolean check[] = new boolean[9];
        int valor;

        for (int i = 0; i < 9; i++) {
            check[i] = false;
        }

        for (int pos = 0; pos < 9; pos++) {
            valor = valores[pos];

            if (valor != 0) {
                if (check[valor - 1] == true) {
                    return false; //==============valores repetidos===========>>
                }

                check[valor - 1] = true;
            }
        }

        return true; //===================no hay valores repetidos============>>
    }

    private boolean validarFils() {

        int valores[] = new int[9];

        //comprueba todas las filas:
        for (int fil = 0; fil < 9; fil++) {
            for (int col = 0; col < 9; col++) {
                valores[col] = this.casillas[fil][col].getValor();
            }

            if (!this.comprobarRepetido(valores)) {
                return false;
            }
        }

        return true;
    }

    private boolean validarCols() {

        int valores[] = new int[9];

        //comprueba todas las columnas:
        for (int col = 0; col < 9; col++) {
            for (int fil = 0; fil < 9; fil++) {
                valores[fil] = this.casillas[fil][col].getValor();
            }

            if (!this.comprobarRepetido(valores)) {
                return false;
            }
        }

        return true;
    }

    private boolean validarSectores() {

        boolean check[] = new boolean[9];
        int valor;

        for (int sectorX = 0; sectorX < 3; sectorX++) {
            for (int sectorY = 0; sectorY < 3; sectorY++) {

                for (int i = 0; i < 9; i++) {
                    check[i] = false;
                }

                for (int fil = sectorX * 3; fil < (sectorX * 3) + 3; fil++) {
                    for (int col = sectorY * 3; col < (sectorY * 3) + 3; col++) {

                        valor = this.casillas[fil][col].getValor();

                        if (valor != 0) {
                            if (check[valor - 1] == true) {
                                return false;
                            }

                            check[valor - 1] = true;
                        }
                    }
                }
            }
        }

        return true;
    }

    private void addCasillaFija(int valor, int fil, int col) {

        CasillaFija casillaF = new CasillaFija(this);

        casillaF.setText(Integer.toString(valor));

        casillas[fil][col] = casillaF;
        casillas[fil][col].setValor(valor);
        casillas[fil][col].setTablero(this);

        jpSudoku.add(casillaF);
    }

    private void addCasillaVariable(int fil, int col) {

        CasillaVariable casillaV = new CasillaVariable(this);

        casillas[fil][col] = casillaV;
        casillas[fil][col].addActionListener(this);
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

    //mas cambio de semaforo
    @Override
    public void actionPerformed(ActionEvent e) {

        int num;

        JButton jbCasilla = (JButton) e.getSource();
        Casilla casilla = (Casilla) e.getSource();
        Tablero tablero = this;
        Semaforo semaforo = this.partida.getJuego().getSemaforo();

        String numCasilla;

        num = casilla.getValor();
        num++;

        if (num == 10 || num == 0) {
            num = 1;
        }

        //casilla recive el nuevo valor
        casilla.setValor(num);

        //casilla recive el valor que debe mostrar por pantalla
        numCasilla = Integer.toString(num);
        jbCasilla.setText(numCasilla);

        if (!tablero.validarMov()) { //valida si el movimiento es correcto
            semaforo.cambioColor(0);

        } else if (!tablero.validarVictoria()) { //valida si ha ganado o no
            semaforo.cambioColor(1);

        } else {
            semaforo.cambioColor(2);
        }
    }

}
