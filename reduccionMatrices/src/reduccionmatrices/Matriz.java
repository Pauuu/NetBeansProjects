package reduccionmatrices;

import java.util.Scanner;

public class Matriz {

    int columnas, filas;
    int matriz[][];

    public static void main(String[] args) {

        int n, m;
        System.out.println("Intoduce numero de filas: ");
        n = pedirNumero();

        System.out.println("Introduce numero de columnas: ");
        m = pedirNumero();

        Matriz mtrz = new Matriz(m, n);
        mtrz.cerebro();

    }

    public Matriz(int n, int m) {   //solo se usa una vez en el main
        this.columnas = n;
        this.filas = m;

        matriz = new int[filas][columnas];
        rellenarArray(matriz);
    }

    public Matriz(int mtrz[][]) {

        this.matriz = mtrz;

        this.columnas = mtrz.length;
        this.filas = mtrz[0].length;
    }

    public static int pedirNumero() {
        int num;

        while (true) {

            try {
                Scanner sc = new Scanner(System.in);
                num = sc.nextInt();
                System.out.println("");

                if (num < 0) {
                    System.out.println("Ha de ser un numero par \n");

                } else if (num % 2 != 0) {
                    System.out.println("Ha de ser un número positivo \n");

                } else {
                    return num;
                }

            } catch (Exception e) {
                System.out.println("Numeros porfavor \n");
            }
        }
    }

    public void cerebro() {

        this.reduccionArray(matriz);
    }

    public void calculoValores(int m[][], int mNueva[][]) {
        int val;

        for (int fil = 0; fil < mNueva.length; fil++) {
            for (int col = 0; col < mNueva[fil].length; col++) {

                val = 1;

                for (int i = fil * 2; i < (fil + 1) * 2; i++) {
                    for (int j = col * 2; j < (col + 1) * 2; j++) {

                        val = val * m[i][j];
                    }
                }

                mNueva[fil][col] = val;
            }
        }
    }

    public void copiarArray(int nueva[][], int original[][]) {
        for (int fil = 0; fil < original.length; fil++) {
            for (int col = 0; col < original[fil].length; col++) {

                nueva[fil][col] = original[fil][col];
            }
        }
    }

    public void mostrarArray(int m[][]) {

        for (int fil = 0; fil < m.length; fil++) {
            for (int col = 0; col < m[fil].length; col++) {
                System.out.print(m[fil][col] + "\t");
            }

            System.out.println();
        }

        System.out.println();
    }

    public void reduccionArray(int m[][]) {

        boolean par;
        int col, fil, colNueva, filNueva;
        int mNueva[][];

        par = true;
        this.mostrarArray(m);

        while (par) {

            fil = m.length;
            col = m[0].length;

            colNueva = col / 2;
            filNueva = fil / 2;

            mNueva = new int[filNueva][colNueva];

            this.calculoValores(m, mNueva);

            m = new int[filNueva][colNueva];

            this.copiarArray(m, mNueva);
            this.mostrarArray(m);

            if (colNueva % 2 != 0 || filNueva % 2 != 0) {
                par = false;
                System.out.println("Aqui acaba el programa!");
            }
        }
    }

    public void rellenarArray(int m[][]) {
        int num;

        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[i].length; j++) {

                num = (int) (Math.random() * 11);
                m[i][j] = num;
            }
        }
    }

    public int[][] getMatrizReducida() {     //devuelve la matriz reducida. Utiliza atributos de la calse. y rellena
        int m, n, mtrz[][];

        m = filas / 2;
        n = columnas / 2;

        mtrz = new int[m][n];
        rellenarArray(mtrz);

        return mtrz;
    }

    public void setColumnas(int columnas) {
        this.columnas = columnas;
    }

    public void setFilas(int filas) {
        this.filas = filas;
    }
}
