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
        calculoPrimos();
    }

    private static void calculoPrimos() {
        int numero;
        int posicion;
        int residuo;
        int primos[] = new int[100];   //almacenamietno de numeros primos
        boolean primo;

        numero = 4;

        for (posicion = 0; posicion < 100;) {       //bucle hasta llegar a 100 primos   
            for (;; numero++) {           //bucle que busca numeros primos
                if (numero == 2) {
                    primo = true;
                    break;
                } else if (numero % 2 == 0) {
                    primo = false;
                    break;
                } else {
                    for (int primoNum = 0; primoNum <= posicion; primoNum++) {
                        residuo = numero % primos[primoNum];
                        if (residuo == 0) {
                            primo = false;
                            break;
                        } else {
                            primo = true;
                        }
                    }
                }
            }
            if (primo = true) {
                primos[posicion] = numero;
                posicion++;
            }
        }

        for (posicion = 0; posicion < 100; posicion++) {
            System.out.println(primos[posicion]);
        }
    }
}
