package tresenraya;

public class IA1 extends IA0 {

    private Tablero tablero;

    private int[][] tableroPesos;

    public IA1(Partida p) {
        super(p);
        tablero = p.getTablero();
    }

    /**
     * Realiza un movimiento automáticamente en la primera casilla libre
     * con mayor peso.
     * @return 
     */
    @Override
    public Movimiento mover() {

        indicarTurno();

        int casilla;
        int peso = 0;
        int pesoNuevo;
        int x = 0;
        int y = 0;

        for (int fil = 0; fil < 3; fil++) {
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

    /**
     * Contiene un arreglo de valores. Al introducir unas coordenadas (filas 
     * y columnas) devolverá el valor de dicha casilla.
     * @param fila Marca la fila deseada.
     * @param columna Marca la columnda deseada.
     * @return 
     */
    private int calculoPesos(int fila, int columna) {   //hacerlos publicos

        tableroPesos = new int[][]{{3, 2, 3}, {2, 4, 2}, {3, 2, 3}};
        return tableroPesos[fila][columna];
    }

    private boolean casillaVacia(int casilla) {
        return casilla == -1;
    }

    private void indicarTurno() {
        System.out.println("\n --- MVIMIENTO REALIZADO POR LA IA ---");
    }
}
