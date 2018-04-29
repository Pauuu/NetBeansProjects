package proyectosudoku ;



public class ProyectoSudoku {
    
    private Juego juego; 
    
    public static void main(String[] args){
    Juego j = new Juego();
    Sudoku s = new Sudoku();
    s.test();
    j.setVisible(true);
    
    }
 
    public ProyectoSudoku(){
        
    }
}
