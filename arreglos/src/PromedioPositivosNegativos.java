import java.util.Scanner;

public class PromedioPositivosNegativos {
    public static void main(String[] args) {

        int[] a = new int[7];
        int sumPos = 0, sumNeg = 0, contCeros = 0, contPos = 0,contNeg = 0;
        Scanner s = new Scanner(System.in);

        System.out.println("Ingrese 7 enteros (positivos o negativos o 0's)");
        for(int i = 0; i < a.length; i++){
            a[i] = s.nextInt();
        }


        for(int i = 0; i < a.length; i++){
            if(a[i] == 0) {
                contCeros++;
            } else {

                if(a[i] > 0) {
                    sumPos += a[i];
                    contPos++;
                }

                if(a[i] < 0) {
                    sumNeg += a[i];
                    contNeg++;
                }
            }

        }

        if(contPos == 0) {
            System.out.println("No hubo elementos positivos");
        } else {
            System.out.println("El promedio de los numeros positivos es: " + sumPos / contPos);
        }

        if(contNeg == 0) {
            System.out.println("No hubo elementos negativos");

        } else {
            System.out.println("El promedio de los numeros negativos es: " + sumNeg / contNeg);
        }

        if(contCeros == 0) {
            System.out.println("No hubo ningún cero");
        } else {
            System.out.println("El total de ceros es " + contCeros);
        }
    }
}
