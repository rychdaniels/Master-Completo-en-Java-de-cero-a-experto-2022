package org.aguzman.poosobrecarga;

public class EjemploSobrecarga {
    public static void main(String[] args) {

        Calculadora cal = new Calculadora();

        System.out.println("sumar int : " + cal.sumar(10, 5));
        System.out.println("sumar float: " + cal.sumar(10.0F, 5F));
        System.out.println("sumar float-int: " + cal.sumar(10f, 5));
        System.out.println("sumar int-float: " + cal.sumar(10, 5.0F));
        System.out.println("sumar double: " + cal.sumar(10.0, 5.0));
        System.out.println("sumar string: " + cal.sumar("10", "5"));
        System.out.println("sumar tres int: " + cal.sumar(10, 5, 3));
        System.out.println("sumar 4 int: " + cal.sumar(10, 5, 3, 4));
        System.out.println("sumar 6 int: " + cal.sumar(10, 5, 3, 4, 6, 7));
        System.out.println("sumar float + n int: " + cal.sumar(10.5F, 5, 9, 15));
        System.out.println("sumar 4 double: " + cal.sumar(10.0, 5.0, 3.5, 4.5));

        System.out.println("sumar long: " + cal.sumar(10L, 5L));
        System.out.println("sumar int: " + cal.sumar(10, '@'));
        System.out.println("sumar float-int: " + cal.sumar(10F, '@'));

    }
}
