import java.util.Scanner;
public class NumMayor {

    public static void main(String[] args) {

        int[] a = new int[6];
        Scanner s = new Scanner(System.in);

        System.out.println("Ingrese 7 enteros entre 11 y 99:");
        for(int i = 0; i < a.length; i++){
            a[i] = s.nextInt();
        }

        int max = 0;
        for(int i = 1; i < a.length; i++){
            max = (a[max] > a[i])? max: i;
        }
        System.out.println("max = " + a[max]);
    }

}
