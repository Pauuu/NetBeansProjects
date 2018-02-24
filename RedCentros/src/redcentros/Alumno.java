package redcentros;

public class Alumno {

    //ATRIBUTOS
    private String apellido;
    private String nombre;
    private String dni;

    //METODOS
    public Alumno(String apellido, String nombre, String dni) {
        this.apellido = apellido;
        this.nombre = nombre;
        this.dni = dni;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }
    
}
