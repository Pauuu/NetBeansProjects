
package tresenraya;

/**
 *
 * @author pau
 */
public class IA3 extends IA2 {

    private Tablero tablero;
    private int[][] tableroPesos;

    public IA3(Partida p) {
        super(p);
        tablero = p.getTablero();
    }

    @Override
    public Movimiento mover() {

        imprimeTurno();

        int casilla;
        int peso = 0;
        int pesoNuevo;
        int x = 0;
        int y = 0;

        if (movGanador() != null) {
            return movGanador();
        }
        
        if (movJoder() != null){
            return movJoder();
        }

        for (int fil = 0; fil < 3; fil++) { //crear nuevo método privado (?)
            for (int col = 0; col < 3; col++) {
                casilla = tablero.getCasilla(fil, col);

                if (casillaVacia(casilla)) {
                    pesoNuevo = calculoPesos(fil, col);

                    if (peso < pesoNuevo) {
                        peso = pesoNuevo;
                        x = fil;
                        y = col;
                    }
                }
            }
        }
        return new Movimiento(this, x, y);
    }

    private boolean casillaVacia(int casilla) {
        return casilla == -1;
    }

    private Movimiento movGanador() {

        int ficha;
        int[][] casillas;

        ficha = this.partida.getTurno();
        casillas = this.tablero.getCasillas();

        if (validaMovGanadorFils(casillas, ficha) != null) {
            return validaMovGanadorFils(casillas, ficha);
        }

        if (validaMovGanadorCols(casillas, ficha) != null) {
            return validaMovGanadorCols(casillas, ficha);
        }

        if (validaMovGanadorDiags(casillas, ficha) != null) {
            return validaMovGanadorDiags(casillas, ficha);
        }

        return null;

    }

    private Movimiento movJoder() {

        int ficha;
        int[][] casillas;

        ficha = this.partida.getTurno();
        casillas = this.tablero.getCasillas();

        ficha = (ficha + 1) % 2;

        if (validaMovGanadorFils(casillas, ficha) != null) {
            return validaMovGanadorFils(casillas, ficha);
        }

        if (validaMovGanadorCols(casillas, ficha) != null) {
            return validaMovGanadorCols(casillas, ficha);
        }

        if (validaMovGanadorDiags(casillas, ficha) != null) {
            return validaMovGanadorDiags(casillas, ficha);
        }

        return null;

    } //Autor del nombre: B. Salleras

    private Movimiento validaMovGanadorCols(int[][] casillas, int ficha) {

        Movimiento mov = null;
        int casillasVacias;

        for (int col = 0; col < 3; col++) {
            casillasVacias = 0;

            for (int fil = 0; fil < 3; fil++) {

                if (casillas[fil][col] != ficha && casillas[fil][col] != -1) {
                    mov = null;
                    break;
                }

                if (casillas[fil][col] == -1) {
                    casillasVacias++;

                    if (casillasVacias > 1) {
                        mov = null;
                        break;
                    }

                    mov = new Movimiento(this, fil, col);  //posible mov ganador
                }
            }

            if (mov != null) {
                return mov; //-------------------MOVIMIENTO GANADOR------------>
            }
        }
        return null; //-------------NO HAY MOVIMIETNO GANADOR------------------>
    }

    private Movimiento validaMovGanadorDiags(int[][] casillas, int ficha) {

        Movimiento mov = null;
        int casillasVacias;

        casillasVacias = 0;

        for (int fil = 0; fil < 3; fil++) {
            int col = fil;

            if (casillas[fil][col] != ficha && casillas[fil][col] != -1) {
                mov = null;
                break;
            }

            if (casillas[fil][col] == -1) {
                casillasVacias++;

                if (casillasVacias > 1) {
                    mov = null;
                    break;
                }

                mov = new Movimiento(this, fil, col);  //posible mov ganador
            }
        }

        if (mov != null) {
            return mov; //-------------------MOVIMIENTO GANADOR---------------->
        }

        casillasVacias = 0;

        for (int fil = 0; fil < 3; fil++) {
            for (int col = 2; col >= 0; col--) {

                if (casillas[fil][col] != ficha && casillas[fil][col] != -1) {
                    mov = null;
                    break;
                }

                if (casillas[fil][col] == -1) {
                    casillasVacias++;

                    if (casillasVacias > 1) {
                        mov = null;
                        break;
                    }

                    mov = new Movimiento(this, fil, col);  //posible mov ganador
                }
            }
        }

        if (mov != null) {
            return mov; //-------------------MOVIMIENTO GANADOR---------------->
        }

        return null; //------------NO HAY MOV GANADOR-------------------------->
    }

    private Movimiento validaMovGanadorFils(int[][] casillas, int ficha) {

        Movimiento mov = null;
        int casillasVacias;

        for (int fil = 0; fil < 3; fil++) {
            casillasVacias = 0;

            for (int col = 0; col < 3; col++) {

                if (casillas[fil][col] != ficha && casillas[fil][col] != -1) {
                    mov = null;
                    break;
                }

                if (casillas[fil][col] == -1) {
                    casillasVacias++;

                    if (casillasVacias > 1) {
                        mov = null;
                        break;
                    }

                    mov = new Movimiento(this, fil, col);  //posible mov ganador
                }
            }

            if (mov != null) {
                return mov; //-------------------MOVIMIENTO GANADOR------------>
            }
        }
        return null; //-------------NO HAY MOVIMIETNO GANADOR------------------>
    }

    private int calculoPesos(int fila, int columna) {
        tableroPesos = new int[][]{{3, 2, 3}, {2, 4, 2}, {3, 2, 3}};
        return tableroPesos[fila][columna];
    }

    private void imprimeTurno() {
        System.out.println("\n --- MVIMIENTO REALIZADO POR LA IA ---");
    }
}
