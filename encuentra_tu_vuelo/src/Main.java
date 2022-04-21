import org.rraya.colecciones.vuelo.dominio.Vuelo;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static java.util.Comparator.comparing;

public class Main {
    public static void main(String[] args) throws ParseException {
        List<Vuelo> vuelos = new ArrayList<>();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm");

        vuelos.add(new Vuelo("AAL 933", "New York", "Santiago", dateFormat.parse("2021-08-29 05:39"), 62));
        vuelos.add(new Vuelo("LAT 755", "Sao Pulo", "Santiago", dateFormat.parse("2021-08-31 04:45"), 47));
        vuelos.add(new Vuelo("SKU 621", "Rio De Janeiro", "Santiago", dateFormat.parse("2021-08-30 05:39"), 52));
        vuelos.add(new Vuelo("DAL 147", "Atlanta", "Santiago", dateFormat.parse("2021-08-29 13:22"), 59));
        vuelos.add(new Vuelo("AVA 241", "Bogota", "Santiago", dateFormat.parse("2021-08-31 14:05"), 25));
        vuelos.add(new Vuelo("AMX 10", "Mexico City", "Santiago", dateFormat.parse("2021-08-31 05:20"), 29));
        vuelos.add(new Vuelo("IBE 6833", "Londres", "Santiago", dateFormat.parse("2021-08-30 08:45"), 55));
        vuelos.add(new Vuelo("LAT 2479", "Frankfurt", "Santiago", dateFormat.parse("2021-08-29 07:41"), 51));
        vuelos.add(new Vuelo("SKU 803", "Lima", "Santiago", dateFormat.parse("2021-08-30 10:35"), 48));
        vuelos.add(new Vuelo("LAT 533", "Los Ángeles", "Santiago", dateFormat.parse("2021-08-29 09:14"), 59));
        vuelos.add(new Vuelo("LAT 1447", "Guayaquil", "Santiago", dateFormat.parse("2021-08-31 08:33"), 31));
        vuelos.add(new Vuelo("CMP 111", "Panama City", "Santiago", dateFormat.parse("2021-08-31 15:15"), 29));
        vuelos.add(new Vuelo("LAT 705", "Madrid", "Santiago", dateFormat.parse("2021-08-30 08:14"), 47));
        vuelos.add(new Vuelo("AAL 957", "Miami", "Santiago", dateFormat.parse("2021-08-29 22:53"), 60));
        vuelos.add(new Vuelo("ARG 5091", "Buenos Aires", "Santiago", dateFormat.parse("2021-08-31 09:57"), 32));
        vuelos.add(new Vuelo("LAT 1283", "Cancún", "Santiago", dateFormat.parse("2021-08-31 04:00"), 35));
        vuelos.add(new Vuelo("LAT 579", "Barcelona", "Santiago", dateFormat.parse("2021-08-29 07:45"), 61));
        vuelos.add(new Vuelo("AAL 945", "Dallas-Fort Worth", "Santiago", dateFormat.parse("2021-08-30 07:12"), 58));
        vuelos.add(new Vuelo("LAT 501", "París", "Santiago", dateFormat.parse("2021-08-29 18:29"), 49));
        vuelos.add(new Vuelo("LAT 405", "Montevideo", "Santiago", dateFormat.parse("2021-08-30 15:45"), 39));
        System.out.println("**********************************************");
        System.out.println("***** Lista Original *****");
        System.out.println("**********************************************");
        for (Vuelo vuelo: vuelos) {
            System.out.println(vuelo.getFechaLlegada());
        }
        System.out.println();

        List<Vuelo> vueloPorFecha = vuelos;
        System.out.println("**********************************************");
        System.out.println("***** Vuelos ordenados por fecha *****");
        System.out.println("**********************************************");
        vueloPorFecha.sort(comparing(Vuelo::getFechaLlegada));
        for (Vuelo vuelo: vueloPorFecha) {
            System.out.println(vuelo.getFechaLlegada());
        }
        Vuelo ultimoVueloPorFecha = vueloPorFecha.get(vuelos.size() - 1);
        System.out.println("El último vuelo en llegar es " + ultimoVueloPorFecha.getNombre() + ": " + ultimoVueloPorFecha.getOrigen()
                + ", aterriza el " + ultimoVueloPorFecha.getFechaLlegada());

        System.out.println();

        List<Vuelo> vueloPorNumPasajeros = vuelos;
        vueloPorNumPasajeros.sort(comparing(Vuelo::getCantidadPasajeros));
        Vuelo vueloConMinPasajeros = vueloPorNumPasajeros.get(0);
        System.out.println("**********************************************");
        System.out.println("El vuelo con menor número de pasajeros es " + vueloConMinPasajeros.getNombre() + ": "
                + vueloConMinPasajeros.getOrigen() + ", con " + vueloConMinPasajeros.getCantidadPasajeros() + " pasajeros");



    }
}
