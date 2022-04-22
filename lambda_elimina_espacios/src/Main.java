import java.util.Locale;

public class Main {
    public static void main(String[] args) {

        IFormatearTexto resultadoFormato = (texto) -> texto.replace(" ", "")
                .replace(",", "")
                .replace(".", "")
                .toUpperCase();

        imprimirTexto("..Ho.la..,,  Co,.m, o....eS,,  T  a..s,,  ", resultadoFormato);
    }

    public static void imprimirTexto(String texto, IFormatearTexto textoFormato){
        String resultado = textoFormato.formateaTexto(texto);
        System.out.println(resultado);
    }
}
