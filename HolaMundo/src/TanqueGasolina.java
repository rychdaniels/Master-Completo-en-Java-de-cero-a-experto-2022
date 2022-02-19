import java.util.Scanner;

public class TanqueGasolina {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        System.out.println("Ingrese la cantidad de gasolina");
        Double gasolina = entrada.nextDouble();

        if( gasolina == 70 ){
            System.out.println("Estanque lleno");
        }
        if( gasolina >= 60 && gasolina < 70 ){
            System.out.println("Estanque casi lleno");
        }

        if( gasolina >= 40 && gasolina < 60 ){
            System.out.println("Estanque 3/4");
        }

        if( gasolina >= 35 && gasolina < 40 ){
            System.out.println("Medio estanque");
        }

        if( gasolina >= 20 && gasolina < 35 ){
            System.out.println("Suficiente");
        }

        if( gasolina >= 1 && gasolina < 20 ){
            System.out.println("Insuficiente");
        }
    }
}
