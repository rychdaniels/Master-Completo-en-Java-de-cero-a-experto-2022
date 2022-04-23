import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int []arrNumeros = new int[100];

        for (int i = 0; i < arrNumeros.length; i++) {
            arrNumeros[i] = i + 1;
        }

        Double resultado = Arrays.stream(arrNumeros)
                .filter(e -> e % 10 != 0)
                .mapToDouble(e -> e/2 )
                .reduce(0, (a,b) -> a+b);

        System.out.println("resultado = " + resultado);

    }
}
