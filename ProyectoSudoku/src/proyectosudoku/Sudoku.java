package proyectosudoku;

import java.util.ArrayList;

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
            {6, 3, 2, 7, 8, 1, 9, 4, 5},
            {4, 8, 7, 5, 9, 6, 2, 1, 3},
            {5, 1, 9, 2, 4, 3, 8, 7, 6},
            {8, 6, 4, 3, 5, 2, 7, 9, 1},
            {7, 5, 0, 9, 6, 8, 3, 2, 4},
            {2, 9, 3, 1, 7, 4, 6, 5, 8},
            {9, 4, 5, 6, 3, 7, 1, 8, 2},
            {1, 7, 6, 8, 2, 5, 4, 3, 9},
            {3, 2, 8, 4, 1, 9, 5, 6, 7}
        };
        this.listaSudokus.add(sudoku2);

    }

    /**
     *
     * @param ID del ArrayList
     * @return
     */
    public int[][] getValoresSudoku(int id) {
        return listaSudokus.get(id);
    }
    
    public int totalSudokus(){
        return this.listaSudokus.size();
    }

}
