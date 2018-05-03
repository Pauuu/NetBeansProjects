package proyectosudoku;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

public class EventoCasillaPulsada implements ActionListener {

    public EventoCasillaPulsada() {

    }

    //mas cambio de semaforo
    public void actionPerformed(ActionEvent e) {

        JButton jbCasilla = (JButton) e.getSource();
        Casilla casilla = (Casilla) e.getSource();
        String numCasilla;

        int num = casilla.getValor();
        num++;

        if (num == 10 || num == 0) {
            num = 1;
        }

        //casilla recive el nuevo valor
        casilla.setValor(num);

        //casilla recive el valor que debe mostrar por pantalla
        numCasilla = Integer.toString(num);
        jbCasilla.setText(numCasilla);

        this.comprobarValores(e);

    }

    /*
    public void comprobarValores(ActionEvent e) {

        Casilla c = (Casilla) e.getSource();
        Tablero tablero = c.getTablero();
        Semaforo s = tablero.getPartida().getJuego().getSemaforo();

        if (!this.comprobarFilas(tablero)) {
            s.cambioColor(0);
        } else if (!this.comprobarColumnas(tablero)) {
            s.cambioColor(0);
        } else if (!this.comprobarSectores(tablero)) {
            s.cambioColor(0);
        } else if (!this.comprobarVictoria(tablero)) {
            s.cambioColor(1);
        } else {
            s.cambioColor(2);
        }

    }

     */
 /*
    private boolean comprobarCasillas(int[] lista) {

        for (int num = 0; num < 8; num++) {
            for (int pivote = num + 1; pivote < 9; pivote++) {
                if (lista[pivote] != 0 || lista[num] != 0) {
                    if (lista[num] == lista[pivote]) {
                        return false;

                    }
                }
            }
        }

        return true;
    }

    private boolean comprobarColumnas(Tablero t) {

        boolean correcto;
        int[] aux = new int[9];
        int[][] numeros = t.getValoresCasillas().clone();

        for (int fil = 0; fil < 9; fil++) {
            for (int col = 0; col < 9; col++) {
                aux[col] = numeros[fil][col];
            }

            // si hay un error:
            if (!this.comprobarCasillas(aux)) {
                return false;    //=====================fallo=================>>
            }
        }

        return true;
    }

    private boolean comprobarFilas(Tablero t) {

        int[] aux = new int[9];
        int[][] numeros = t.getValoresCasillas().clone();

        for (int fil = 0; fil < 9; fil++) {
            for (int col = 0; col < 9; col++) {
                aux[col] = numeros[fil][col];
            }

            // si hay un error:
            if (!this.comprobarCasillas(aux)) {
                return false;    //=====================fallo=================>>
            }
        }

        return true;
    }
     */
    private boolean comprobarVictoria(Tablero t) {

        int[] aux = new int[9];
        int[][] numeros = t.getValoresCasillas().clone();
        int total = 0;

        for (int fil = 0; fil < 9; fil++) {

            total = 0;
            for (int col = 0; col < 9; col++) {
                total = total + numeros[fil][col];
            }

            if (total != 45) {
                return false;
            }
        }

        return true;
    }

    private boolean comprobarSectores(Tablero t) {

        int pos;
        int[] aux = new int[9];
        int[][] numeros = t.getValoresCasillas().clone();

        for (int sectorX = 0; sectorX < 3; sectorX++) {
            for (int sectorY = 0; sectorY < 3; sectorY++) {

                pos = 0;

                for (int fil = sectorX * 3; fil < (sectorX * 3) + 3; fil++) {
                    for (int col = sectorY * 3; col < (sectorY * 3) + 3; col++) {
                        aux[pos] = numeros[fil][col];
                        pos++;
                    }
                }

                // si hay un error:
                if (!this.comprobarCasillas(aux)) {
                    return false;    //=================fallo=================>>
                }
            }
        }

        return true;
    }
}
