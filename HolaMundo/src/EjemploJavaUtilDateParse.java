import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class EjemploJavaUtilDateParse {
    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

        System.out.println("Ingrese una fecha con formato 'yyyy-MM-dd'");
        try {
            Date fecha = format.parse(s.next());
            System.out.println("fecha = " + fecha);
            System.out.println("format = " + format.format(fecha));
            
            Date fecha2 = new Date();
            System.out.println("fecha2 = " + fecha2);

            if(fecha.after(fecha2)){
                System.out.println("fecha1 (del usuario) es después que fecha2 (actual)");
            } else if(fecha.before(fecha2)){
                System.out.println("fecha es anterior que fecha2");
            } else if(fecha.equals(fecha2)){
                System.out.println("fecha es igual a fecha2");
            }

            if(fecha.compareTo(fecha2) > 0){
                System.out.println("fecha1 (del usuario) es después que fecha2 (actual)");
            } else if(fecha.compareTo(fecha2) < 0){
                System.out.println("fecha es anterior que fecha2");
            } else if(fecha.compareTo(fecha2) == 0){
                System.out.println("fecha es igual a fecha2");
            }

            
        } catch (ParseException e) {
            //e.printStackTrace();
            System.err.println("La fecha tiene un formato incorrecto: " + e.getMessage());
            System.err.println("El formato debe ser 'yyyy-MM-dd'");
            System.exit(1);
            //main(args);
        }
    }
}
