import java.util.Random;

public class NumMasRepetido {
    public static void main(String[] args) {

        Random random = new Random();
        int numeros[] = new int[10];
        int ocurrencias[] = new int[10];

        for (int i = 0; i < numeros.length; i++) {
            numeros[i] = random.nextInt(1 + 10) + 1;
            System.out.println(numeros[i]);
        }

        for (int i = 0; i < numeros.length; i++) {
            int numOcurrencias = 0;
            for (int j = 0; j < numeros.length; j++) {
                if(numeros[i] == numeros[j]){
                    numOcurrencias++;
                }
            }
            ocurrencias[i] = numOcurrencias;
        }

        int maxNumero = 0;
        for (int i = 0; i < ocurrencias.length; i++) {
            if(ocurrencias[i] > maxNumero){
                maxNumero = ocurrencias[i];
            }
        }

        System.out.println("El numero con mayor ocurencia es " + numeros[maxNumero]);
        System.out.println("Aparecio " + ocurrencias[maxNumero] + " veces");


    }
}
