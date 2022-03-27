import java.util.Random;

public class Histograma {
    public static void main(String[] args) {
        Random random = new Random();
        final int tamanio = 12;
        final int tamanioOcurrencias = 6;
        int numeros[] = new int[tamanio];
        int ocurrencias[] = new int[tamanioOcurrencias];

        System.out.println("*********/// LISTA DE NÚMEROS ////**********");
        for (int i = 0; i < tamanio; i++) {
            numeros[i] = random.nextInt(1 + 5) + 1;
            System.out.print(numeros[i] + " ");
        }

        for (int i = 0; i < tamanioOcurrencias; i++) {
            ocurrencias[i] = 0;
        }

        for (int i = 0; i < tamanio; i++) {
            for (int j = 1; j <= 6; j++) {
                if(numeros[i] == j){
                    ocurrencias[j-1] += 1;
                }
            }
        }

        System.out.println("");
        System.out.println("*********/// HISTOGRAMA ////**********");
        for (int i = 0; i < ocurrencias.length; i++) {
            System.out.print(i+1 + ": ");
            for (int j = 0; j < ocurrencias[i]; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
