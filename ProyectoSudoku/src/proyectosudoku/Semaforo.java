package proyectosudoku;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Semaforo extends JPanel {

    JLabel imgSemaforo;
    ImageIcon color;

    public Semaforo() {

        color = new ImageIcon("src/proyectosudoku/semaforoAmarillo.png");
        imgSemaforo = new JLabel(color, JLabel.CENTER);

        this.add(imgSemaforo);

    }

    public void cambioColor(int color) {

        String url = "src/proyectosudoku/semaforoAmarillo.png";
        switch (color) {
            case 0:
                url = "src/proyectosudoku/semaforoRojo.png";
                break;
            case 1:
                url = "src/proyectosudoku/semaforoAmarillo.png";
                break;
            case 2:
                url = "src/proyectosudoku/semaforoVerde.png";
                break;
        }
        
        imgSemaforo.setIcon(new ImageIcon(url));
        this.revalidate();
        this.repaint();
    }

}
