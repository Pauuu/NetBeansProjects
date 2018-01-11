package trasteo;

public class Trasteo {

    public static void main(String[] args) {
        int a[] = new int[12];
            a[0] = 1;
            
            int i = 10+2*2;
            int y = 10+(2*2);
            
            System.out.println(i + " "+ y);
        }
    }




/*
 public static void main(String[] args) {
        int a[][] = new int [4][4];
        
        omplirArrayX(a);
        imprimirArrayX(a);
        
    }
    
    private static void imprimirArrayX(int a[][]) {
        for (int col = 0; col < a.length-1; col++) {
            for (int row = 0; row < a[row].length-1; row++){
                System.out.println(a[row][col]);
            }
        }
    }

    private static void omplirArrayX(int a[][]) {
        for (int col = 0; col < a.length-1; col++) {
            for (int row = 0; row < a[row].length-1; row++){
                a[row][col] = (int) (Math.random() * 10);
                System.out.println(Arrays.toString(a));
            }
        }
    }
}
 */
