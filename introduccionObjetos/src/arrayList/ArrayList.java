/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arrayList;

/**
 *
 * @author pau
 */
public class ArrayList {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

    }

    private static boolean calculoPrimos() {
        int numero;
        int divisor;
        int resul;
        boolean primo;

        for (numero = 2; numero < 100; numero++) {
            if (numero != 2) {
                for (divisor = primo();;) {
                    resul = numero / divisor;
                }
            } else {
                return true;
            }
        }
        return false;
    }

    private static int primo(int primo) {
        int listaPrimos[] = new int [10];
        int posicion;
        
        posicion = 0;
        listaPrimos[posicion] = primo;
    }
}
