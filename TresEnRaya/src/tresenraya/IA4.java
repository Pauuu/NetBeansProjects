/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tresenraya;

/**
 *
 * @author pau
 */
public class IA4 extends IA3 {

    private Tablero tablero;
    private int[][] tableroPesos;
    private int[][] casillasOponente;

    public IA4(Partida p) {
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

        if (movJoder() != null) {
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
        int fichaOp;

        fichaOp = (ficha + 1) % 2;

        for (int col = 0; col < 3; col++) {
            casillasVacias = 0;

            for (int fil = 0; fil < 3; fil++) {

                if (casillas[fil][col] == fichaOp) {
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
        int fichaOp;

        fichaOp = (ficha + 1) % 2;

        casillasVacias = 0;

        for (int fil = 0; fil < 3; fil++) {
            int col = fil;

            if (casillas[fil][col] == fichaOp) {
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

                if (casillas[fil][col] == fichaOp) {
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
        int fichaOp;

        fichaOp = (ficha + 1) % 2;

        for (int fil = 0; fil < 3; fil++) {
            casillasVacias = 0;

            for (int col = 0; col < 3; col++) {

                if (casillas[fil][col] == fichaOp) {
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

        int fichaOp = this.partida.getTurno();

        fichaOp = (fichaOp + 1) % 2;

        for (int fil = 0; fil < 3; fil++) {
            for (int col = 0; col < 3; col++) {
                if (tableroPesos[fil][col] == fichaOp) {

                    for (int x = 0; x < 3; x++) {
                        tableroPesos[fil][x] -= 1;
                    }

                    for (int y = 0; y < 3; y++) {
                        tableroPesos[y][col] -= 1;
                    }

                    if (fil == 2 && col == 2) {
                        for (int i = 0; i < 3; i++) {
                            tableroPesos[i][i] -= 1;
                            tableroPesos[i][2 - i] -= 1;
                        }
                    }

                    if (((fil == 0) && (col == 0)) || ((fil == 2) && (col == 2))) {
                        for (int i = 0; i < 3; i++) {
                            tableroPesos[i][i] -= 1;
                        }
                    }

                    if (((fil == 0) && (col == 2)) || ((fil == 2) && (col == 0))) {
                        for (int i = 0; i < 3; i++) {
                            tableroPesos[i][2 - i] -= 1;
                        }
                    }
                }
            }
        }

        return tableroPesos[fila][columna];
    }

    private void imprimeTurno() {
        System.out.println("\n --- MVIMIENTO REALIZADO POR LA IA ---");
    }

}
