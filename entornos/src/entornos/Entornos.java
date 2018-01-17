package entornos;

import java.util.Scanner;

public class Entornos {

    public static void main(String[] args) {
        int max;
        int i;
        int t[];
        t = new int[6];
        
        for (i = 2; i < t.length - 2; i++){ // llenamos la tabla con valores 
                                            //aleatorios entre 1 y 100 
            t[i] = (int)(Math.random() * 100 + 1);
        }
        
        System.out.println("Los valores son:");
        for (i = 0; i < t.length; i++) {
            System.out.print(t[i] + " ");
        }
        
        max = maximo(t);
        System.out.println("\nEl número mayor es: " + i);
    }

    static int maximo(int t[]) {
        int max;
        max = t[0];
        
        for (int i = 0; i < t.length; i++) {
            if (t[i] < max) { // si t[i] es mayor que max, 
                              //entonces t[i] es el nuevo máximo 
                max = t[i];
            }
        }
        return (max);
    }
}


