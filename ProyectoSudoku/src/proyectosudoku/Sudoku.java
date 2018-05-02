package proyectosudoku;

import java.util.ArrayList;
import java.util.Arrays;

public class Sudoku {

    private ArrayList<int[][]> listaSudokus;

    public Sudoku() {
        listaSudokus = new ArrayList<>();

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
        
        int[][] sudoku2 = {
            {9, 9, 9, 9, 0, 1, 9, 6, 3},
            {4, 0, 0, 9, 0, 7, 0, 0, 0},
            {9, 0, 3, 8, 0, 0, 1, 0, 0},
            {9, 7, 0, 9, 0, 9, 6, 0, 1},
            {9, 0, 0, 0, 0, 0, 0, 0, 0},
            {6, 0, 1, 2, 0, 4, 0, 3, 9},
            {9, 0, 9, 0, 0, 6, 7, 0, 4},
            {9, 0, 0, 7, 0, 0, 0, 0, 6},
            {9, 6, 5, 1, 0, 2, 3, 0, 8}
        };
        this.listaSudokus.add(sudoku2);

        
    }

    /**
     * @deprecated no hace lo que tenia en mente
     */
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

        int[][] e = new int[9][9];
        e = listaSudokus.get(0);

        for (int fila = 0; fila < e.length; fila++) {
            System.out.println(e[0][fila]);
        }
    }

    /**
     * 
     * @param id Usar siempre el ID 0
     * @return 
     */
    public int[][] getValoresSudoku(int id) {
        
        return listaSudokus.get(id);
    }
}
