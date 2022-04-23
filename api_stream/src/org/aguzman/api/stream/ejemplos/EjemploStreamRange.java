package org.aguzman.api.stream.ejemplos;

import java.util.IntSummaryStatistics;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class EjemploStreamRange {
    public static void main(String[] args) {

        IntStream num =  IntStream.range(5, 20).peek(System.out::println);
        
        // int resultado = num.reduce(0, Integer::sum);
        // int resultado = num.sum();
        IntSummaryStatistics stats = num.summaryStatistics();
        System.out.println("max: " + stats.getMax());
        System.out.println("min: " + stats.getMin());
        System.out.println("sum: " + stats.getSum());
        System.out.println("promedio: " + stats.getAverage());
        System.out.println("total: " + stats.getCount());



    }
}
