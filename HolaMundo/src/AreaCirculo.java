import java.util.Scanner;

public class AreaCirculo {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        System.out.println("Ingrese el radio del circulo");
        try {
            double radio = entrada.nextDouble();
            double area = Math.PI * Math.pow(radio, 2);
            System.out.println("El área del circulo es: " + area);
        } catch (Exception e) {
            System.out.println("Debe ingresar un valor numerico");
            main(args);
        }
    }
}
