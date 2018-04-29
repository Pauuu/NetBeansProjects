package proyectosudoku;

import java.util.ArrayList;
import java.util.Arrays;

public class Sudoku {

    private ArrayList<int[][]> listaSudokus;

    private int id;

    public Sudoku() {

    }

    private void addSudoku() {
        int[][] sudoku1 = {
            {5, 0, 0, 4, 0, 1, 9, 6, 3},
            {4, 0, 0, 0, 0, 7, 0, 0, 0},
            {9, 0, 3, 8, 0, 0, 1, 0, 0},
            {8, 7, 0, 3, 0, 9, 6, 0, 1},
            {0, 0, 0, 0, 0, 0, 0, 0, 0},
            {6, 0, 1, 2, 0, 4, 0, 3, 9},
            {0, 0, 9, 0, 0, 6, 7, 0, 4},
            {0, 0, 0, 7, 0, 0, 0, 0, 6},
            {7, 6, 5, 1, 0, 2, 3, 0, 8}
        };

        this.listaSudokus.add(sudoku1);
    }

    public void test() {
        
        
    }

    public int[][] getSudoku(int id) {
        System.out.println(Arrays.toString(this.listaSudokus.get(1)));

        return this.listaSudokus.get(id);
    }

}
