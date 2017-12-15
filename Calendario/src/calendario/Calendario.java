package calendario;

public class Calendario {

    /* LINEA:
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
        dS = 1;
        
        for (int mes = 1; mes <= 12; mes++) {
            
            System.out.println("\n \n" + meses(mes));
            System.out.print("L  M  X  J  V  S  D \n\n");

            for (dia = 1; dia <= 31; dia++, dS++) {
                System.out.print((dia < 10) ? dia + "  " : dia + " ");
                
                if (dS >= 7) {
                    dS = 0;
                    System.out.println();
                }

                if (dia > 31) {
                    dia = 0;
                }
            }
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
}
