package calendario;

public class Calendario {

    /*
    cambioMes(mes);
    System.out.println("L   M   X   J   V   S   D");
     */
    public static void main(String[] args) {
        calendario();
        meses(2);
    }

    private static void calendario() {
        int dia;
        int dS; // dia semana (Lun-Dom)
        dS = 0;

        for (int mes = 1; mes <= 12; mes++) {

            for (dia = 1; dia <= diasMes(mes); dia++, dS++) {   // "diasMes()" >> los dias de cada mes.

                System.out.print((dia < 10) ? dia + "  " : dia + " ");

                if (dS > 7) {  //salto de línea cada siete dias.
                    dS = 1;
                    System.out.println();
                }

                /*if (dia > 31) {
                    dia = 0;
                } */
            }
            System.out.println();

        }
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

}
