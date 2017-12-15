
package ejerciciolectura3;

public class Ejerciciolectura3 {

    
    public static void main(String[] args) {
        int i, c;
        double d;
        boolean b;

        c = i = 0;
        b = true;

        while (b) {
            d = Math.random() * 100;
            i = (int) d;
            b = i != 50;
            c++;
        }
        System.out.println(c);
    }

}
