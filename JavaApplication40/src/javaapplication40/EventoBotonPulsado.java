
package javaapplication40;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class EventoBotonPulsado implements ActionListener {

    public void actionPerformed(ActionEvent e) {
        String str = e.getActionCommand();
        JButton boton = (JButton) e.getSource();

        for (int i = 0; i < 10; i++) {
            if (str.equals(Integer.toString(i))) {

                if (i == 9) {
                    i = 0;
                }
                
                String texto = Integer.toString(i+1);
                boton.setText(texto);
                break;
            }
        }

    }

    private void cambioNum(ActionEvent e) {
        JButton casilla = (JButton) e.getSource();

        casilla.setText("nada de momento");
    }

    private void elegirNum(ActionEvent e) {
        JButton casilla = (JButton) e.getSource();
    }
}
