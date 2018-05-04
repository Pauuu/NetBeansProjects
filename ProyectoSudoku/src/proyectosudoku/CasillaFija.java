package proyectosudoku;

import java.awt.Color;
import java.awt.Font;

public class CasillaFija extends Casilla {

    public CasillaFija(Tablero t) {
        super(t);

        this.setBackground(Color.cyan);
        this.setFont(new Font("Courier", Font.BOLD, 40));
        

    }
    
    
}
