/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codewarstrasteo;

/**
 *
 * @author pau
 */
public class CodeWarsTrasteo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        boolean test = isDivisible(100, 10, 5);
        System.out.println(test);
    }

    public static boolean isDivisible(long n, long x, long y) {

        if (n % x != 0) {
            return false;
            
        } else if (n % y != 0) {
            return false;
        }

        return true;
    }

}
