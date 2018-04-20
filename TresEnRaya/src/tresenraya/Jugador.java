package tresenraya;
/**
 * 
 * @author pau
 */

import java.util.Scanner;

public class Jugador {

    Partida partida;
    private String nombre;
    private Tablero tablero;
    

    public Jugador(Partida p) {
        this.partida = p;
        //this.nombre = "humano";
    }

    public Movimiento mover() {

        Scanner scan = new Scanner(System.in);

        int fil, col;

        //Lee coordenadas que pasa el jugador
        System.out.println("\nIndica una columna: ");
        col = scan.nextInt();

        System.out.println("Indica una fila: ");
        fil = scan.nextInt();

        return new Movimiento(this, fil, col);
    }

    public String getNombre() {
        return nombre;
    }

    public void setTablero(Tablero t) {
        this.tablero = tablero;
    }
}
