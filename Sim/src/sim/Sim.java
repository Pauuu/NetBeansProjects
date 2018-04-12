package sim;

public class Sim {

    private static int poblacion;
    private String nombre;
    
    public static void main(String[] args) {
        
        for (int i = 0; i < 10; i++){
            Sim s = new Sim("Sim" + i);
            mostrarPoblacion();
        }
        
    }
    
    public Sim(String nombre){
        this.nombre = nombre;
        poblacion++;
    }
    
    public static void mostrarPoblacion(){
        
        System.out.println(poblacion);
    }
    
}
