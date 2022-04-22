import java.util.Collections;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        String frase = "There are many variations of passages of Lorem Ipsum available but the majority have suffered alteration " +
                "in some form by injected humour or randomised words which look even slightly believable " +
                "If you are going to use a passage of Lorem Ipsum you need to be sure there isn't anything embarrassing hidden in the middle of text " +
                "All the Lorem Ipsum generators on the Internet tend to repeat predefined " +
                "chunks as necessary, making this the first true generator on the Internet It uses a dictionary of over 200 Latin words " +
                "combined with a handful of model sentence structures to generate Lorem Ipsum which looks reasonable. The generated Lorem Ipsum is therefore always free from repetition " +
                "injected humour or non-characteristic words etc";

        IContadorPalabras contPalabras = frases -> {
            //HashMap<String, Integer> respuesta = new HashMap<>();
            String [] arrPalabras = frases.replace(",", "").replace(".", "").toLowerCase().split(" ");
            Integer mayorOcurrencia = 0;
            String palabraMasRepetida = "";
            for (int i = 0; i < arrPalabras.length; i++) {
                System.out.println(arrPalabras[i]);
            }

            for (int i = 0; i < arrPalabras.length; i++) {
                int ocurrencias = 0;
                for (int j = 0; j < arrPalabras.length; j++) {
                    if (arrPalabras[i].equals(arrPalabras[j])) {
                        ocurrencias++;
                    }
                }

                if(ocurrencias > mayorOcurrencia){
                    mayorOcurrencia = ocurrencias;
                    palabraMasRepetida = arrPalabras[i];
                }
            }
            //respuesta.put(palabraMasRepetida, mayorOcurrencia);
            return Collections.singletonMap(palabraMasRepetida, mayorOcurrencia);
        };

        contPalabras.contarPalabras(frase).forEach((key, value)
                -> System.out.println("La paalbra que mas se repite es " + key + " aparece " + value + " veces"));

    }
}
