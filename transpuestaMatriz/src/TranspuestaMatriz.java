
public class TranspuestaMatriz {

    public static void main(String[] args) {
        int A[][];
        int B[][];
        
        A = [5][5];
        B = [5][5];

        imprimirArray(A, B);

    }

    private static void imprimirArray(int a[][]) {

        for (int row = 0; row < a.length; row++) {
            System.out.println("");

            for (int col = 0; col < a[row].length; col++) {
                System.out.print(a[row][col] + " ");
            }
        }
    }

    public static void rellenarArray(int a[][], int b[][]) {
        for (int row = 0; row < a.length; row++) {
            for (int col = 0; col < a[row].length; col++) {
                a[row][col] = (int) Math.random() * 10;
                b[row][col] = (int) Math.random() * 10;
            }
        }
    }
}
