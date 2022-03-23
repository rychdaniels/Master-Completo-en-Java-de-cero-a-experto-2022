import java.util.Arrays;

public class EjemploArreglosForInverso {
    public static void main(String[] args) {
        
        //String[] productos = new String[7];
        String[] productos = { "Kingston Pendrive 64GB", "Samsung Galaxy",
                "Disco Duro SSD Samsung Externo",
                "Asus Notebook", "Macbook Air",
                "Chromecast 4ta generación", "Bicicleta Oxford" };

        int total = productos.length;

        /*productos[0] = "Kingston Pendrive 64GB";
        productos[1] = "Samsung Galaxy";
        productos[2] = "Disco Duro SSD Samsung Externo";
        productos[3] = "Asus Notebook";
        productos[4] = "Macbook Air";
        productos[5] = "Chromecast 4ta generación";
        productos[6] = "Bicicleta Oxford";
*/
        Arrays.sort(productos);
        System.out.println("=== Usando for ===");
        for(int i = 0; i < total; i++){
            System.out.println("para indice " + i + " : " + productos[i]);
        }

        System.out.println("=== Usando for inverso ===");
        for(int i = 0; i < total; i++){
            System.out.println("para i = " + (total-1-i) + " valor: " + productos[total-1-i]);
        }

        System.out.println("=== Usando for inverso 2 ===");
        for(int i = total - 1; i >= 0; i--){
            System.out.println("para i = " + i + " valor " + productos[i]);
        }

    }
}
