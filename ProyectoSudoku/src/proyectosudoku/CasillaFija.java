package proyectosudoku;

import java.awt.Color;
import java.awt.Font;

public class CasillaFija extends Casilla {

    public CasillaFija(String str) {
        super();

        this.setBackground(Color.cyan);
        this.setFont(new Font("Courier", Font.BOLD, 40));
        this.setText(str);

    }
}
