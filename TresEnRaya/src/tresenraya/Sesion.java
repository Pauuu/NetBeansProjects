package tresenraya;
/**
 * 
 * @author pau
 */

import java.util.Scanner;

public class Sesion {

    //ATRIBUTOS
    private Jugador[] jugador = new Jugador[2];
    private Partida partida;
    private Ranking ranking;

    public Sesion() {
        //Crea la partida
        Partida p = new Partida();
        this.partida = p;
    }

    /**
     * Crea una partida con la IA deseada.
     * 
     * @see IA0  IA0
     * @see IA1  IA1
     * @see IA2  IA2
     * @see IA3  IA3
     * @see IA4  IA4
     */
    public void crearPartida() {

        Scanner scan = new Scanner(System.in);
        int IA = -1;
        
        this.mostrarDificultad();
        
        dificultad:
        while (true) {

            IA = scan.nextInt();
            
            switch (IA) {
                case 0:
                    this.crearIA0();
                    break dificultad;

                case 1:
                    this.crearIA1();
                    break dificultad;

                case 2:
                    this.crearIA2();
                    break dificultad;

                case 3:
                    this.crearIA3();
                    break dificultad;

                case 4:
                    this.crearIA4();
                    break dificultad;

                default:
                    System.out.println("Elije una opcion valida");
                    break;
            }
        }

        crearRanking();
        //crearIA4();
        crearHumano();  //siempre es el 0 (de momento)
        sorteoTurno();

        partida.jugar(ranking);
    }

    public void crearRanking() {
        Ranking r = new Ranking();
        this.setRanking(r);
    }

    public void crearHumano() {
        Jugador j0 = new Jugador(partida);
        this.jugador[0] = j0;
    }

    public void crearIA0() { //cambiar
        IA0 j1 = new IA0(partida);
        this.jugador[1] = j1;
    }

    public void crearIA1() { //cambiar
        IA0 j1 = new IA1(partida);
        this.jugador[1] = j1;
    }

    public void crearIA2() { //cambiar
        IA0 j1 = new IA2(partida);
        this.jugador[1] = j1;
    }

    public void crearIA3() {
        IA3 j1 = new IA3(partida);
        this.jugador[1] = j1;
    }

    public void crearIA4() {
        IA4 j1 = new IA4(partida);
        this.jugador[1] = j1;
    }

    public void menu() {

        Scanner scan = new Scanner(System.in);
        int opcion;

        menu:
        while (true) {
            
            this.mostrarMenu();
            opcion = scan.nextInt();

            switch (opcion) {
                case 1:
                    this.crearPartida();
                    break;

                case 2:
                    this.mostrarRanking();  //gestionar excepción
                    break;
                    
                case 3:
                    break menu;

                default:
                    System.out.println("Elije una opción valida \n");  //CAMBIAR
                    break;
            }
        }
    }

    public void mostrarRanking() {
        ranking.mostrar(); //CREAR METODO
    }

    public void sorteoTurno() { //pasa jugadores. Primero blancas, luego negras
        int moneda = (int) (Math.random() * 2);   //0 cara; 1 cruz

        if (moneda == 0) {
            partida.setJugadores(jugador[0], jugador[1]);//jugador0->blancas
        } else {
            partida.setJugadores(jugador[1], jugador[0]);//jugador1->blancas
        }
    }

    private void mostrarMenu() {
        System.out.println("Elije una de las opciones:");
        System.out.println(
                "1: Jugar \n"
                + "2: Ranking \n"
                + "3: Salir");
    }

    private void mostrarDificultad() {
        System.out.println("Elije nivel IA");
        System.out.println("Opciones: 0, 1 ,2, 3, 4");
    }

    //GETTES / SETTERS
    public void setPartida(Partida partida) {
        this.partida = partida;
    }

    public Ranking getRanking() {
        return ranking;
    }

    public void setRanking(Ranking ranking) {
        this.ranking = ranking;
    }

}
