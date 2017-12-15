package ordenacion3;

public class Ordenaciones {

    public static void main(String[] args) {
        int a[] = new int [4];
        int orden[] = new int [4];
        
        System.out.println("Array desordenado");
        omplirArray(a);
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
    
    private static void ordArray (int a[]){
        
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
