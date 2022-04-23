import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        String[][] lenguajes = {{"java", "groovy"}, {"php"}, {"c#", "python", "groovy"},
                {"java", "javascript", "kotlin"}, {"javascript"}, {}};

        Arrays.stream(lenguajes)
                .flatMap( e -> Arrays.stream(e))
                .distinct()
                .forEach(System.out::println);
    }
}
