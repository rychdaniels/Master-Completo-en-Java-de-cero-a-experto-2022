import java.util.Arrays;
import java.util.function.Function;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {

        Integer[] numsArr = {1, 312, 4, 242, 32, 13, -11, 1, 0 , 10, 304, 544, 0};


        Function<Integer[], Integer> mayorNumero = arrNum -> Arrays.stream(arrNum)
                .reduce(0, (a, b) -> a > b ? a : b);

        Integer resultado = mayorNumero.apply(numsArr);
        System.out.println(resultado);
    }
}
