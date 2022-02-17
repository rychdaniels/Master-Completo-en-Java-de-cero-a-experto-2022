import java.util.Scanner;

public class ProgramaManejoDeNombres {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String [] nombres = new String[3];

        System.out.println("Ingrese el nombre de la primer persona");
        String nombrePersona1 = scanner.nextLine();
        nombres[0] = nombrePersona1;

        System.out.println("Ingrese el nombre de la segunda persona");
        String nombrePersona2 = scanner.nextLine();
        nombres[1] = nombrePersona2;

        System.out.println("Ingrese el nombre de la tercer persona");
        String nombrePersona3 = scanner.nextLine();
        nombres[2] = nombrePersona3;


        String letraMayuscula = "";
        int tamanioNombre = 0;
        String ultimoTexto = "";
        String textoFinal = "";

        for (int i = 0; i < nombres.length; i++){
            letraMayuscula = nombres[i].toUpperCase().substring(1,2);
            tamanioNombre = nombres[i].length();
            ultimoTexto = nombres[i].substring(tamanioNombre-2, tamanioNombre);
            textoFinal += letraMayuscula.concat(".").concat(ultimoTexto);
            System.out.println(i + " " + nombres.length);
            if(i != nombres.length - 1){
                textoFinal = textoFinal.concat("_");
            }
        }

        System.out.println(textoFinal);
    }
}
