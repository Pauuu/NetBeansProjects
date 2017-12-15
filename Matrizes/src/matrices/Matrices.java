package matrices;

public class Matrices {
        // para usar la funcon "suma": imprimirArray(suma(a, b));

    public static void main(String[] args) {
        int a[][] = new int[3][3];
        int b[][] = new int[3][3];

        rellenarArray(a);
        imprimirArray(a);

        System.out.println();

        rellenarArray(b);
        imprimirArray(b);

        System.out.println();

        imprimirArray(suma(a, b));

    }

    private static void imprimirArray(int a[][]) {

        for (int row = 0; row < a.length; row++) {
            System.out.println("");

            for (int col = 0; col < a[row].length; col++) {
                System.out.print(a[row][col] + " ");
            }
        }
    }

    private static void rellenarArray(int a[][]) {
        for (int row = 0; row < a.length; row++) {
            for (int col = 0; col < a[row].length; col++) {
                a[row][col] = (int) (Math.random() * 10);
            }
        }
    }

    private static int[][] suma(int a[][], int b[][]) {
        int maxRow;
        int maxCol;

        maxCol = a.length;
        maxRow = maxCol;

        int resul[][] = new int[maxRow][maxCol];

        for (int row = 0; row < maxRow; row++) {
            for (int col = 0; col < maxCol; col++) {
                resul[row][col] = a[row][col] + b[row][col];
            }
        }
        return resul;
    }
}
