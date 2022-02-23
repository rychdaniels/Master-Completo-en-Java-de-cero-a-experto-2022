import java.util.Scanner;

public class SentenciaSwitchCaseNumDiasMes {
    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        System.out.println("Ingrese el número del mes de 1 - 12");
        int mes = s.nextInt();

        int numeroDias = 0;
        System.out.println("Ingrese el año (YYYY)");
        int anio = s.nextInt();

        switch(mes){
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                numeroDias = 31;
                break;
            case 4:
            case 6:
            case 9:
            case 11:
                numeroDias = 30;
                break;
            case 2:
                if(anio % 400 == 0 || ( (anio % 4 == 0) && !(anio % 100 == 0))){
                    numeroDias = 29;
                } else {
                    numeroDias = 28;
                }
                break;
            default:
                numeroDias = 0;
        }

        System.out.println("numeroDias = " + numeroDias);
    }
}
