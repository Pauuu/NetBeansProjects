package trasteo;

import java.util.ArrayList;

public class Trasteo {

    public static void main(String[] args) {
        //ArrayList
        int simpleArray[] = new int[5];

        ArrayList<String> myList = new ArrayList<>(5);
        myList.add("s");
        myList.add("d");
        myList.add("d");

        System.out.println("size " + myList.size());
        for (String i : myList) {
            System.out.println(i);
        }

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
