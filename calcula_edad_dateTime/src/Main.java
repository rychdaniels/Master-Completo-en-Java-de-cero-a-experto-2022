import javax.swing.*;
import java.time.Duration;
import java.time.LocalDate;
import java.time.Period;
import java.util.zip.DataFormatException;

public class Main {
    public static void main(String[] args) {
        try{

            String fecha = JOptionPane.showInputDialog(null, "Ingresa tu fecha de nacimiento en formato yyyy-mm-dd");
            LocalDate fechaNacimiento = LocalDate.parse(fecha);

            Period edad = Period.between(fechaNacimiento, LocalDate.now());
            JOptionPane.showMessageDialog(null, "Tienes " + edad.getYears() + " años");
        } catch (Exception dfe){
            JOptionPane.showMessageDialog(null, "Ingresa una edad con formato válido");
            main(args);
        }
    }
}
