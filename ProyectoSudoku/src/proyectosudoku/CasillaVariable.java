package proyectosudoku;

import java.awt.Font;

public class CasillaVariable extends Casilla {

    public CasillaVariable(String str) {
        super();

        this.setFont(new Font("Courier", Font.BOLD, 40));
        this.setText(str);
       
    }

    public void introducirValor() {

    }
}
