/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package introduccionobjetos;

/**
 *
 * @author pau
 */
public class IntroduccionObjetos {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

    }

    private static boolean primos() {
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
}
