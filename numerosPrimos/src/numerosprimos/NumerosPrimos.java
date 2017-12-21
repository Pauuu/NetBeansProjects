/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package numerosprimos;

/**
 *
 * @author pau
 */
public class NumerosPrimos {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int num = 2;
        int numLectura = 0;
        int position = 0;
        int primos[] = new int[100000];
        boolean save = true;
        
        
        for (; primos[99999] == 0;) {
            for (; primos[numLectura] != 0;) {
                if ((2 * primos[numLectura]) > num) {
                    save = true;
                    break;
                }
                if (num % primos[numLectura] != 0) {
                    save = true;
                } else {
                    save = false;
                    break;
                }
                numLectura++;
            }
            if (save == true) {
                primos[position] = num;
                System.out.println("El numero " + primos[position] + " es primo");
                position++;
            }
            save = false;
            num++;
            numLectura = 0;
        }
    }

}
