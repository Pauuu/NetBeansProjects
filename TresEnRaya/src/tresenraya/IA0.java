package tresenraya;

public class IA0 extends Jugador {

    private Tablero tablero;
    
    public IA0(Partida p) {
        super(p);
        tablero = p.getTablero();
    }

    @Override
    public Movimiento mover() {

        indicarTurno();

        int casilla;

        for (int fil = 0; fil < 3; fil++) {
            for (int col = 0; col < 3; col++) {
                casilla = tablero.getCasilla(fil, col); //recupera valoor de una casilla
                if (casilla == -1) {
                    return new Movimiento(this, fil, col);
                }
            }
        }
        return null;
    }

    private void indicarTurno() {
        System.out.println("\n --- TURNO DE LA IA +++ TURNO DE LA IA ---");
    }
}
