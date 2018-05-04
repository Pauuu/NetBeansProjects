package proyectosudoku;

import java.awt.Font;

public class CasillaVariable extends Casilla {

    public CasillaVariable(Tablero t) {
        super(t);

        this.setFont(new Font("Courier", Font.BOLD, 40));
        

    }
}
