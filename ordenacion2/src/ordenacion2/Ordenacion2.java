package ordenacion2;

public class Ordenacion2 {

    public static void main(String[] args) {
        int a[] = new int[4];

        System.out.println("Array desordenado:");
        omplirArray(a);
        imprimirArray(a);

        System.out.println("Array ordenado");
        ordInserccion(a);
        imprimirArray(a);
    }

    private static void imprimirArray(int[] a) {
        for (int pasada = 0; pasada < a.length;
                pasada++) {
            System.out.println(a[pasada]);
        }
    }

    private static void omplirArray(int a[]) {
        for (int i = 0; i < a.length; i++) {
            a[i] = (int) (Math.random() * 1000);
        }
    }

    private static void ordSeleccion(int a[]) {
        int indiceMenor, aux, pasada, posicion;

        for (pasada = 0; pasada < a.length - 1; pasada++) {
            indiceMenor = pasada;
            for (posicion = pasada + 1; posicion < a.length; posicion++) {
                if (a[posicion] < a[indiceMenor]) {
                    indiceMenor = posicion;
                }

                if (pasada != indiceMenor) {
                    aux = a[pasada];
                    a[pasada] = a[indiceMenor];
                    a[indiceMenor] = aux;
                }
            }
        }
    }

    private static void ordInserccion(int a[]) {
        int i, j;
        int aux;
        
        for (i = 1; i < a.length; i++){
    /* índice j explora la sublista a[0]..a[i-1] buscando la
    posición correcta del elemento destino, lo asigna a a[j] */
            
            j = i;
            aux = a[i];
            while (j > 0 && aux < a[j - 1]){
                a[j] = a[j - 1];
                j--;
            }
            a[j] = aux;
        }
    }
}
