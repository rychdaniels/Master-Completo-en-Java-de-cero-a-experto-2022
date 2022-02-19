import java.util.Scanner;

public class NumeroMayor {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        System.out.println("Ingrese el promer numero");
        Integer num1 = entrada.nextInt();

        System.out.println("Ingrese el segundo numero");
        Integer num2 = entrada.nextInt();

        Integer numeroMayor = num1 > num2 ? num1 : num2;

        System.out.println("El numero mayor es ".concat(numeroMayor.toString()));
    }
}
