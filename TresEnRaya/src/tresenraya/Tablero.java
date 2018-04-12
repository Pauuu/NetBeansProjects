package tresenraya;

/**
 *
 * @version 1.2.3.4.5.6.7.8.9.0
 * @author pau
 */
public class Tablero {

    private Partida partida;
    private int[][] casillas = new int[3][3];

    public Tablero(Partida p) {
        partida = p;

        for (int fil = 0; fil < 3; fil++) {
            for (int col = 0; col < 3; col++) {
                casillas[fil][col] = -1;        //comprobar si funciona o no
            }
        }
    }

    public boolean comprobarGanador() {
        return comprobarFilas() || comprobarColumnas() || comprobarDiagonal();
    }

    public void limpiarTablero() {
        for (int fil = 0; fil < 3; fil++) {
            for (int col = 0; col < 3; col++) {
                casillas[fil][col] = -1;        //comprobar si funciona o no
            }
        }
    }

    /**
     *
     * Muestra el tablero con las fichas si las hubiera. En caso de no haber
     * fichas, lo muestra con puntos centrados.
     */
    public void mostrar() {
        // Mostrar el tablero

        System.out.print(" 0  1   2  \n");

        for (int fil = 0; fil < 3; fil++) {
            for (int col = 0; col < 3; col++) {

                if (casillas[fil][col] == -1) {
                    System.out.print(" · ");

                } else if (casillas[fil][col] != -1) {
                    System.out.print((casillas[fil][col] == 0) ? " O " : " X ");
                }
            }
            System.out.println();
        }
    }

    /**
     * @deprecated Usar el método "mostrar".
     *
     * Mustra el tablero, pero los números no quedan alineados con el tablero.
     * No muestra puntos simulando cada casilla.
     *
     */
    public void mostrar2() {
        // Mostrar el tablero

        System.out.print("0 1 2");

        for (int fil = 0; fil < 3; fil++) {
            for (int col = 0; col < 3; col++) {

                if (casillas[fil][col] != -1) {
                    System.out.print((casillas[fil][col] == 0) ? " O " : " X ");
                }
            }
            System.out.println();
        }
    }

    /**
     * En base a un objeto Movimiento, introduce en las coordenadas de la matriz
     * (tablero) la ficha.
     *
     * Dependiendo del atributo "isBlancas" del objeto Movimiento la ficha será
     * balnca (0) o negra (1).
     *
     * @param m Movimiento
     */
    public void realizarMov(Movimiento m) {

        int fil, col;

        fil = m.getFil();
        col = m.getCol();

        if (m.isBlancas()) {
            casillas[fil][col] = 0; //blancas
        } else {
            casillas[fil][col] = 1; //negras
        }
    }

    private boolean comprobarFilas() {

        //filas
        for (int fil = 0; fil < 3; fil++) {
            if ((casillas[fil][0] == 0) && (casillas[fil][1] == 0) && (casillas[fil][2] == 0)) {
                return true;
            }

            if ((casillas[fil][0] == 1) && (casillas[fil][1] == 1) && (casillas[fil][2] == 1)) {
                return true;
            }
        }
        return false;
    }

    private boolean comprobarColumnas() {

        //columnas
        for (int col = 0; col < 3; col++) {
            if ((casillas[0][col] == 0) && (casillas[1][col] == 0) && (casillas[2][col] == 0)) {
                return true;
            }

            if ((casillas[0][col] == 1) && (casillas[1][col] == 1) && (casillas[2][col] == 1)) {
                return true;
            }
        }
        return false;
    }

    private boolean comprobarDiagonal() {

        for (int i = 0; i < 3; i++) {

            //diagonal 1
            if ((casillas[0][0] == i) && (casillas[1][1] == i) && (casillas[2][2] == i)) {
                return true;
            }

            //diagonal 2
            if ((casillas[0][2] == i) && (casillas[1][1] == i) && (casillas[2][0] == i)) {
                return true;
            }
        }

        return false;
    }

    public boolean tableroLleno() {

        for (int fil = 0; fil < 3; fil++) {
            for (int col = 0; col < 3; col++) {
                if (casillas[fil][col] == -1) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean validarCasillaVacia(Movimiento m) {

        int fil, col;

        fil = m.getFil();
        col = m.getCol();

        return casillas[fil][col] == -1;
    }

    public boolean validarMovimiento(Movimiento m) {

        int fil, col;

        fil = m.getFil();
        col = m.getCol();

        return !((fil < 0) || (fil > 2) || (col < 0) || (col > 2));
    }

    public int getCasilla(int fil, int col) {
        int casilla = casillas[fil][col];
        return casilla;
    }

    public int[][] getCasillas() {
        return casillas;
    }
}
