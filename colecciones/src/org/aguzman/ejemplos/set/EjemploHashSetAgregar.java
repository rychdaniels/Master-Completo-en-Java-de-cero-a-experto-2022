package org.aguzman.ejemplos.set;

import java.util.*;

public class EjemploHashSetAgregar {
    public static void main(String[] args) {

        Set<String> hs = new HashSet<>();
        System.out.println(hs.add("uno"));
        System.out.println(hs.add("dos"));
        System.out.println(hs.add("tres"));
        System.out.println(hs.add("cuatro"));
        System.out.println(hs.add("cinco"));
        System.out.println(hs);

        boolean b = hs.add("tres");
        System.out.println("permite elementos duplicados = " + b);
        System.out.println(hs);

    }
}
