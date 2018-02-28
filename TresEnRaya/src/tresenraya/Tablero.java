package tresenraya;

public class Tablero {

    private int[][] casillas = new int[3][3];

    public Tablero() {
        for (int x = 0; x < casillas[x].length; x++) {
            for (int y = 0; y < casillas[x][y]; y++) {
                casillas[x][y] = -1;        //comprobar si funciona o no
            }
        }
    }

    public boolean comprobarGanador() {

        return false;
    }

    public void mostrar() {
        // TODO implement me    
    }

    public void movimiento(Movimiento m) {
        int movX = m.getFil();
        int movY = m.getCol();
        
        casillas[movX][movY] = 0;
        
    }

    public void validarmovimiento(Movimiento m) {
        // TODO implement me    
    }

    public boolean getcasilla(Jugador fil, Jugador col) {
        // TODO implement me 
        return false;
    }
}
