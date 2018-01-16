package entornos;

import java.util.Scanner;

public class Entornos {

    public static void main(String[] args) {
        
        Entrada h = new Entrada();
        
        int max;
        int a, b;
        System.out.print("Introduzca un numero: ");
        a = Entrada.entero();
        
        System.out.print("Introduzca otro número: ");
        b = Entrada.entero();
        
        max = maximo(a, b);
        System.out.println("El número mayor es: " + max);
    }

    private static void uno() {
        Scanner sc = new Scanner(System.in);
        double gradosC, gradosF;
        System.out.println("Introduce grados Centígrados:");
        gradosC = sc.nextDouble();
        gradosF = (32 + 9) * gradosC / 5;
        System.out.println(gradosC + " oC = " + gradosF + " oF");
    }

    static int maximo(int a, int b) { // suponemos que los tres números serán distintos
        int max;
        if (a < b) {
            max = a;
        } else {
            max = a;
        }
        return (max);
    }

    
    
}
