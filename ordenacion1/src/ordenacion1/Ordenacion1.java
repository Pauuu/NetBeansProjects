package ordenacion1;

public class Ordenacion1 {

    public static void main(String[] args) {
        int z;
        int aux;
        double d;

        int v[] = new int[100];

        for (int i = 0; i < v.length; i++) {
            v[i] = (int) (Math.random() * 1000);
        }

        for (int i = 0; i <= v.length - 2; i++) {
            for (int j = i + 1; j <= v.length - 1; j++) {
                if (v[i] > v[j]) {
                    aux = v[i];
                    v[i] = v[j];
                    v[j] = aux;
                }
            }
        }

        for (int i = 0; i < v.length; i++) {
            System.out.println(v[i]);
        }

    }
}
    
    /*  codigo de maria
    package primero;

public class ordIntercambio {

    public static void main(String[] args) {
        int a[];

        a = new int[100];

        System.out.println("Array desordenado:");
        omplirArray(a);
        imprimirArray(a);
        ordenarArray(a);

        System.out.println("  ");
        System.out.println("Array ordenado:");
        imprimirArray(a);
    }

    private static void imprimirArray(int[] a) {
        for (int i = 0; i < a.length;
                i++) {
            System.out.print(a[i] + "  ");

        }
    }

    private static void omplirArray(int a[]) {
        for (int i = 0; i < a.length; i++) {
            a[i] = (int) (Math.random() * 1000);
        }
    }

    private static void ordenarArray(int[] a) {
        // Controlar el nomnbre de passades a realitzar 
        for (int passadaActual = 0; passadaActual <= a.length - 2; passadaActual++) {
            
            // Fer una passada
            for (int elementActual = passadaActual + 1; elementActual <= a.length - 1; elementActual++) {
                
                if (a[passadaActual] > a[elementActual]) {
                    // Realitzar un intercanvi
                    int aux = a[passadaActual];
                    a[passadaActual] = a[elementActual];
                    a[elementActual] = aux;
                }
            }
        }
    }
}
    */


