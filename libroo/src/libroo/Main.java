
package libroo;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Rafael
 */
public class Main {
    public static void main(String[] args) {
       Scanner sn = new Scanner(System.in);
       boolean salir = false;
       int opcion; //Guardaremos la opcion del usuario
       ArrayList<Libro> lista_libros = new ArrayList<>();      
        
       while(!salir){
            
           System.out.println("1. Opcion 1 - Crear libro");
           System.out.println("2. Opcion 2 - Prestar libro");
           System.out.println("3. Opcion 3 - Devolver libro");
           System.out.println("4. Opcion 4 - Localizar libro");  
           System.out.println("5. Opcion 5 - Mostrar libro");             
           System.out.println("6. Salir");
            
           System.out.println("Escribe una de las opciones");
           opcion = sn.nextInt();
           switch(opcion){
               case 1:
                   System.out.println("Has seleccionado la opcion 1 - Crear libro");
                   lista_libros.add(Libro.crear_Libro());
                   break;
               case 2:
                   System.out.println("Has seleccionado la opcion 2 - Prestar libro");
                   Libro.pedir_prestar_Libro(lista_libros);
                   break;
                case 3:
                   System.out.println("Has seleccionado la opcion 3 - Devolver libro");
                   Libro.pedir_devolver_Libro(lista_libros);
                   break;
                case 4:
                   System.out.println("Has seleccionado la opcion 4 - Localizar libro");
                   Libro.localizar_Libro(lista_libros);
                   break;   
                case 5:
                   System.out.println("Has seleccionado la opcion 5 - Mostrar libro");
                   Libro.localizar_Libro(lista_libros);
                   break;                    
                case 6:
                   salir=true;
                   break;
                default:
                   System.out.println("Solo números entre 1 y 6");
           }           
            
       }
    }
}
