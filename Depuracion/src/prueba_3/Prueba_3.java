package prueba_3;


//comentario








public class Prueba_3 {
 
    public static void main(String[] args) {
        long i, j, c;
        long tInicial, tFinal;
        boolean b;
 
        c = i = j = 0;
 
        System.out.println("> Start");
        tInicial = System.nanoTime();
        b = true;
        while (b) {
            i = (int) (Math.random() * 10000000); // 100 millones
            j = (int) (Math.random() * 10000000); // 100 millones
            b = i != j;
            c++;
        }
        tFinal = System.nanoTime();
        System.out.println("< End");
 
        System.out.println("Seconds: "
                + (double) (tFinal - tInicial) * Math.pow(10, -9));
        System.out.println("Numbers: " + i + " - " + j);
        System.out.println("Counter: " + c);
    }
}