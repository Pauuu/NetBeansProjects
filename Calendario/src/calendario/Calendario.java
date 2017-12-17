package calendario;

public class Calendario {

    /*
    cambioMes(mes);
    System.out.println("L   M   X   J   V   S   D");
     */
    
    
    public static void main(String[] args) {
        calendario();
    }

    private static void arrayMeses(){
        int dia[];
        int diaSemana[];
        
    }
    
    private static void calendario() {
        int dia;
        int dS;
        dS = 0;
        //Bluce sobre meses

        for (int mes = 1; mes <= 12; mes++) {

            System.out.println(meses(mes));
            System.out.println("L  M  X  J  V  S  D");

            for (int espacio = 0; espacio < dS; espacio++) {
                System.out.print("   ");
            }

            //Bucle sobre dias más dias de la semana (Lun, Mar, Mie, ... Dom)
            for (dia = 1; dia <= diasMes(mes); dia++, dS++) {   // "diasMes()" >> los dias de cada mes.

                if (dS >= 7) {  //salto de línea cada siete dias.
                    dS = 0;
                    System.out.println();
                }

                System.out.print((dia < 10) ? dia + "  " : dia + " ");
            }

            System.out.println("\n");

        }
    }

    private static int diasMes(int mes) {
        //los dias que teiene cada mes

        switch (mes) {
            case 1:
                mes = 31;
                break;
            case 2:
                mes = 28;
                break;
            case 3:
                mes = 31;
                break;
            case 4:
                mes = 30;
                break;
            case 5:
                mes = 31;
                break;
            case 6:
                mes = 30;
                break;
            case 7:
                mes = 31;
                break;
            case 8:
                mes = 31;
                break;
            case 9:
                mes = 30;
                break;
            case 10:
                mes = 31;
                break;
            case 11:
                mes = 30;
                break;
            case 12:
                mes = 31;
                break;
            default:
                mes = 0;
                break;
        }
        return mes;
    }

    private static String meses(int mes) {

        String mesString;

        switch (mes) {
            case 1:
                mesString = "January";
                break;
            case 2:
                mesString = "February";
                break;
            case 3:
                mesString = "March";
                break;
            case 4:
                mesString = "April";
                break;
            case 5:
                mesString = "May";
                break;
            case 6:
                mesString = "June";
                break;
            case 7:
                mesString = "July";
                break;
            case 8:
                mesString = "August";
                break;
            case 9:
                mesString = "September";
                break;
            case 10:
                mesString = "October";
                break;
            case 11:
                mesString = "November";
                break;
            case 12:
                mesString = "December";
                break;
            default:
                mesString = "Invalid month";
                break;
        }

        return (mesString);
    }
    
     
}
