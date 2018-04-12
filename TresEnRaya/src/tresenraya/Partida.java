package tresenraya;

public class Partida {

    //ATRIBUTOS
    private int turno;
    private Jugador jugador[] = new Jugador[2];
    private Jugador jugadorActual;
    private Tablero tablero;

    //METODOS
    //Publicos
    public Partida() {
        Tablero t = new Tablero(this);
        this.tablero = t;
    }

    public void jugar(Ranking rank) {

        /*Crea el tablero*/
        boolean empate;
        boolean victoria;
        Movimiento mov;
        int i;  //index para hacer el resto para poder cambiar de turno        

        empate = false;
        victoria = false;
        i = 1;

        turno = 0;

        if (this.jugador[0] instanceof IA1) {
            jugador[0].setTablero(tablero);
        } else {
            jugador[1].setTablero(tablero);
        }

        while (!victoria && !empate) {

            jugadorActual = this.jugador[turno];

            this.tablero.mostrar();
            
            mov = this.jugadorActual.mover();

            if (turno == 0) {
                mov.setBlancas(true);
            } else {
                mov.setBlancas(false);
            }

            //valida casilla
            if (!this.tablero.validarMovimiento(mov)) {
                rank.setPartidasJugadas(+1); 
                break;  //---------------sale si movimiento no válido---------->
            }

            //comprueba si casilla es vacia
            if (!this.tablero.validarCasillaVacia(mov)) {
                rank.setPartidasJugadas(+1);
                break;  //----------------sale si casilla vacía---------------->
            }

            //tablero ejecuta el movimiento de jugador
            this.tablero.realizarMov(mov);

            //comprueba si ganador
            victoria = this.tablero.comprobarGanador();
            if (victoria) {
                this.tablero.mostrar();
                rank.ganar();   

                System.out.println("Partida ganada por: "
                        + this.jugadorActual.getNombre() + "\n");
                break;  //----------------------sale si hay victoria----------->
            }

            //comprueba si empate
            empate = this.tablero.tableroLleno();
            if (empate) {
                this.tablero.mostrar();
                rank.empatar();

                System.out.println("Empate. \n");
                break;  //----------------------sale si hay empate------------->
            }
            turno = (i++) % 2; //deberia funcionar bien
        }
        tablero.limpiarTablero();
    }

//GETTERS / SETTERS
    public void setJugadores(Jugador jBlancas, Jugador jNegras) {
        this.jugador[0] = jBlancas;
        this.jugador[1] = jNegras;
    }

    public Tablero getTablero() {
        return tablero;
    }

    public void setTablero(Tablero tablero) {
        this.tablero = tablero;
    }
    
    public int getTurno(){
        return this.turno;
    }
}
