import java.util.Scanner;

public class OrdenarUltimoPrimero {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int arreglo[];
        arreglo = new int[10];
        for (int i = 0; i < 10; i++) {
            System.out.println("Ingrese un numero: ");
            arreglo[i] = scanner.nextInt();
        }

        for (int i = 0; i <= 4; i++) {
            System.out.println(arreglo[9 - i]);
            System.out.println(arreglo[i]);
        }
    }

}
