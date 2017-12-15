package asteriscoyobelisco;

public class AsteriscoYObelisco {

    public static void main(String[] args) {

        int altura;
        int base;

        altura = 8;
        base = 12;

        trianguloVacio1(base);
    }

    private static void cuadrado(int maxRow, int maxCol) {
        for (int row = 0; row < maxRow; row++) {
            for (int col = 0; col < maxCol; col++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    private static void cuadradoVacio(int base, int altura) { //OPTIMIZAR//

        int row = 0;
        for (; row < 1; row++) {
            for (int col = 0; col < base; col++) {
                System.out.print("*");
            }
        }
        System.out.println();
        for (; row < altura - 1; row++) {
            for (int col = 0; col < base; col++) {
                if (col == 0 || col == base - 1) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
        for (; row < altura; row++) {
            for (int col = 0; col < base; col++) {
                System.out.print("*");
            }
        }
    }

    private static void triangulo1(int base) {
        for (int row = 0; row < base; row++) {
            for (int col = 0; col <= row; col++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    private static void triangulo2(int base) {
        for (int row = 0; row < base; row++) {
            int col = 0;

            for (; col < (base - 1) - row; col++) {
                System.out.print("-");
            }
            for (; col < base; col++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    private static void triangulo3(int base) {
        for (int row = base; row > 0; row--) {
            for (int col = 0; col < row; col++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    private static void triangulo4(int base) {
        for (int row = base; row > 0; row--) {
            int col = 0;

            for (; col < (base) - row; col++) {
                System.out.print(" ");
            }
            for (; col < base; col++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    private static void trianguloVacio1(int base) {
        for (int row = 0, col = 0; row <= base || col <= base; row++, col++) {
            System.out.print((col == 0 || col == row || row == base) ? "*" : " ");
            System.out.print((col == base) ? "\n" :"");
        }
    }

    private static void trianguloVacio2(int base) {
        for (int row = 0; row <= base; row++) {

            for (int col = 0; col <= base; col++) {
                System.out.print((col == base - row || col == base || row == base) ? "*" : " ");
            }

            System.out.println();
        }
    }

    private static void trianguloVacio3(int base) {
        for (int row = base; row == base; row++) {
            for (int col = 0; col <= row; col++) {
                System.out.print("*");
            }
            System.out.println();

            for (row = base - 1; row >= 0; row--) {
                int col = 0;
                for (; col <= base; col++) {
                    if (col == base - row || col == base) {
                        System.out.print("*");
                    } else {
                        System.out.print(" ");
                    }
                }
                System.out.println();
            }

        }
    }

    private static void trianguloVacio4(int base) {
        for (int row = base; row == base; row++) {
            for (int col = 0; col <= row; col++) {
                System.out.print("*");
            }
        }
        System.out.println();

        for (int row = base - 1; row >= 0; row--) {
            for (int col = 0; col <= row; col++) {
                if (col == 0 || col == row) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }

    }

    private static void triangulo1v2(int base) {
        for (int row = 0; row < base; row++) {
            int col = 0;

            for (; col < (base - 1) - row; col++) {
                System.out.print("");
            }
            for (; col < base; col++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    private static void triangulo3v2(int base) {
        for (int row = base; row > 0; row--) {
            int col = 0;

            for (; col < base - row; col++) {
                System.out.print("");
            }
            for (; col < base; col++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    private static void cuadradoOptimizado(int base, int altura) {  //noooooooo
        for (int col = 0, row = 0; col <= base && row < altura; col++) {
            System.out.print((col == base) ? "\n" : "*");
            if (col == base) {
                row++;
                col = 0;
            }
        }
    }
}
