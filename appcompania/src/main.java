import org.rraya.compania.dominio.Gerente;

public class main {
    public static void main(String[] args) {
        Gerente gerente = new Gerente("Ricardo", "Raya", "12.345.678-9", "C. Cedro 2000", 16000.00, 1, 1000.00);
        gerente.aumentarRemuneracion(15);
        gerente.setPresupuesto(77000.00);
        System.out.println(gerente);
    }
}
