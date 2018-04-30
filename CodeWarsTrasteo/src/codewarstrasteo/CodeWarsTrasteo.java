/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codewarstrasteo;

import java.util.Arrays;

/**
 *
 * @author pau
 */
public class CodeWarsTrasteo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
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
        
        for (int valor[]:sudoku1){
            System.out.println(Arrays.toString(valor));
        }
        
    }

    

}
