package org.aguzman.datetime.ejemplos;

import java.time.Duration;
import java.time.LocalDateTime;

public class EjemploDuration {
    public static void main(String[] args) {
        
        LocalDateTime fecha1 = LocalDateTime.now();
        // fecha1 = fecha1.withMonth(10);
        LocalDateTime fecha2 = LocalDateTime.now().plusHours(3).plusMinutes(20).plusDays(1);
        Duration lapsus = Duration.between(fecha1, fecha2);
        System.out.println("lapsus = " + lapsus);
        System.out.println(lapsus.toMinutes());
        System.out.println("sumamos 5 horas " + lapsus.plusHours(5));
    }
}
