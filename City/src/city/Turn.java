
package city;


public class Turn {
    private Way viaOrigen;
    private Way viaDestinacio;
    private int posicio; // Metres des de l'oritge

    
    public Turn(Way viaOrigen, Way viaDestinacio, int posicio) {
        
        this.viaOrigen = viaOrigen;
        this.viaDestinacio = viaDestinacio;
        this.posicio = posicio;
    }

    
    public void setViaOrigen(Way via) {
        this.viaOrigen = via;
    }
    
    public void setViaDestinacio(Way via) {
        this.viaDestinacio = via;
    }
}
