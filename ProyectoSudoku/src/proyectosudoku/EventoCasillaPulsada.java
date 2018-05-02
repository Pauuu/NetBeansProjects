/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectosudoku;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

public class EventoCasillaPulsada implements ActionListener {

    public EventoCasillaPulsada() {

    }

    //Meter metodo de comprobacion aqui
    //mas cambio de semaforo
    public void actionPerformed(ActionEvent e) {

        String str = e.getActionCommand();
        JButton casilla = (JButton) e.getSource();

        for (int i = 0; i < 10; i++) {
            if (str.equals(Integer.toString(i)) || str.equalsIgnoreCase("")) {

                if (i == 9) {
                    i = 0;
                }

                String texto = Integer.toString(i + 1);
                casilla.setText(texto);
                break;
            }
        }

        this.comprobacion(e);
    }

    public void comprobacion(ActionEvent e) {
        System.out.println("test");
        
        JButton casilla = (JButton) e.getSource();
        casilla.getT
        
    }
}
