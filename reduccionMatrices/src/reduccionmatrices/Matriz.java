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

        this.mostrarArray(matriz);

        while (true) {

            matriz = this.getMatrizReducida(matriz);
            this.mostrarArray(matriz);

            if (this.getColumnas() % 2 != 0 || this.getFilas() % 2 != 0) {
                break;
            }
        }
    }

    public int[][] ponerValores(int mtrz[][]) {
        int m, n, valor;

        m = mtrz.length;
        n = mtrz[0].length;

        for (int fil = 0; fil < m; fil++) {
            for (int col = 0; col < n; col++) {
                valor = 1;

                for (int i = fil * 2; i < (fil + 1) * 2; i++) {
                    for (int j = col * 2; j < (col + 1) * 2; j++) {

                        valor = valor * matriz[i][j];
                    }
                }
                mtrz[fil][col] = valor;
            }
        }

        return mtrz;
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

    public void rellenarArray(int m[][]) {
        int num;

        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[i].length; j++) {

                num = (int) (Math.random() * 11);
                m[i][j] = num;
            }
        }
    }

    public int[][] getMatrizReducida(int mtrz[][]) {     //devuelve la matriz reducida. Utiliza atributos de la calse. y rellena
        int m, n;

        m = mtrz.length / 2;
        n = mtrz[0].length / 2;

        setFilas(n);
        setColumnas(m);

        mtrz = new int[m][n];
        mtrz = ponerValores(mtrz);

        return mtrz;
    }

    public int getColumnas() {
        return this.columnas;
    }

    public int getFilas() {
        return this.filas;
    }

    public void setColumnas(int columnas) {
        this.columnas = columnas;
    }

    public void setFilas(int filas) {
        this.filas = filas;
    }
}
