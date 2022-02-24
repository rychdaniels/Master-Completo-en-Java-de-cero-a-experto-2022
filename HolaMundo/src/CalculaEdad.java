import javax.swing.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CalculaEdad {
    public static void main(String[] args) {
        // 1 año = 31536000000 milisegundos
        final long EQUIVALENTE_MILIS_ANIO = 31536000000L;
        // Obtenemos la fecha de nacimiento
        String edadInput = JOptionPane.showInputDialog("Ingrese fecha de nacimiento en formato yyyy-MM-dd. P.ej: 1985-02-01");
        // Definimos el formato que tendra la fecha
        SimpleDateFormat fechaFormato = new SimpleDateFormat("yyyy-MM-dd");

        try {
            // Parseamos el string a una fecha valida
            Date fechaNacimiento = fechaFormato.parse(edadInput);
            // La fecha actual
            Date fechaActual = new Date();

            // Validamos que la fecha no sea superior a la actual
            if(fechaNacimiento.after(fechaActual)){
                JOptionPane.showMessageDialog(null, "La fecha ingresada no puede ser posterior a la actual");
                return;
            }

            // Obtenemos el tiempo transcurrido hasta ahora en milisegundos
            long tiempoNacimiento = fechaNacimiento.getTime();
            long tiempoActual = fechaActual.getTime();

            // Calculamos la diferencia de tiempos en milisegundos, despues dividimos para obtener los años
            long tiempoTranscurridoEnAnios = (tiempoActual - tiempoNacimiento) / EQUIVALENTE_MILIS_ANIO;
            System.out.println("tiempoTranscurrido = " + tiempoTranscurridoEnAnios);
            if(tiempoTranscurridoEnAnios == 0) {
                JOptionPane.showMessageDialog(null, "Debe haber transcurrido por lo menos un año entre fechas para poder realizar el calculo. Intente con otra fecha");
            } else {
                JOptionPane.showMessageDialog(null, "Tú edad es " + tiempoTranscurridoEnAnios + " años");
            }
        } catch (ParseException e) {
            JOptionPane.showMessageDialog(null, "Ingrese una fecha valida");
            e.printStackTrace();
        }
    }
}
