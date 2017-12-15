package sumamatrices;

public class SumaMatrices {

    public static void main(String[] args) {
        int row;
        int col;
        int maxRow = 3;
        int maxCol = 3;
        int A[][] = new int[3][3];
        int B[][] = new int[3][3];
        int suma[][] = new int[3][3];

        for (row = 0; row < maxRow; row++) {
            for (col = 0; col < maxCol; col++) {
                suma[row][col] = A[row][col] + B[row][col];
            }
        }
        System.out.println(suma[2][2]);
    }
    
    private static void suma(int a[][], int b[][]){
        int maxRow;
        int maxCol;
        
        maxCol = a.length;
        maxRow = a[maxCol].length;
        
        int resul[][] = new int [maxRow][maxCol];
        
        for (int row = 0; row < maxRow; row++) {
            for (int col = 0; col < maxCol; col++) {
                resul[row][col] = a[row][col] + b[row][col];
            }
        }
    }
}