import javax.swing.*;

public class NombreMasLargo {
    public static void main(String[] args) {
        String nombresCompletos[] = new String[3];
        Integer tamanioNombres[] = new Integer[3];

        for (int i = 0; i < 3; i++) {
            nombresCompletos[i] = JOptionPane.showInputDialog("Ingresa tu nombre y apellidos");
            String nombreSplit[] = nombresCompletos[i].split(" ");
            Integer tamanioNombre = nombreSplit[0].length();
            tamanioNombres[i] = tamanioNombre;
        }

        Integer mayor = obtenNombreMayor(tamanioNombres);
        JOptionPane.showMessageDialog(null,  nombresCompletos[mayor] + " tiene el nombre mas largo");
        System.out.println(nombresCompletos[mayor] + " tiene el nombre mas largo");
    }

    public static Integer obtenNombreMayor(Integer[] tamanioNombres){
        Integer mayor = null;

        mayor = tamanioNombres[0] > tamanioNombres[1] ? 0 : 1;
        mayor = tamanioNombres[mayor] > tamanioNombres[2] ? mayor : 2;

        return  mayor;
    }
}
