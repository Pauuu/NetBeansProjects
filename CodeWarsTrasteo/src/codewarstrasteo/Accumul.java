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
public class Accumul {

    public Accumul() {
    }

    public static String accum(String s) {
        char letter;
        String resul = "";

        for (int i = 0; i < s.length(); i++) {
            letter = s.charAt(i);

            for (int j = 0; j <= i; j++) {

                resul = resul + (j == 0
                        ? Character.toUpperCase(letter)
                        : Character.toLowerCase(letter));
            }

            if (i == s.length() - 1) {
                return resul;
            }

            resul = resul + "-";
        }

        return resul;
    }

}
