package org.mj.module5.lesson20;

import java.util.IntSummaryStatistics;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class TerminalMethods {
    public static void main(String[] args) {
        IntSummaryStatistics intSummaryStatistics = IntStream.rangeClosed(1, 1000).summaryStatistics();
        System.out.println(intSummaryStatistics);

        // Terminal operation 'pulls' the data.
        // If there is no terminal operation, there will be no processing of elements
        IntStream.range(1, 10)
                .peek(s -> System.out.println("Processing item: " + s))
                .forEach(System.out::println); // Comment this line and no processing will happen.

        System.out.println("----------------");

        IntStream.range(1, 10)
                .peek(s -> System.out.println("Processing item: " + s))
                .allMatch(x -> x < 4); // only process 4 elements

        System.out.println("----------------");

        var count = IntStream.range(1, 10)
                .peek(s -> System.out.println("Processing item: " + s))//.filter(x -> x < 5) // uncomment this line and all elements will be pulled
                .count(); // No items were pulled from pipeline for processing
        System.out.println("Count is: " + count);
    }
}
