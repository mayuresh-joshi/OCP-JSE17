package org.mj.module5.lesson20;

import java.util.Spliterator;
import java.util.stream.IntStream;

public class StreamUtilities {
    public static void main(String[] args) {
        IntStream.rangeClosed(1, 1000)
                .filter(value -> value % 2 != 0)
                .forEach(System.out::println);

        Spliterator.OfInt sp1 = IntStream.range(0, 999).spliterator();

        sp1.tryAdvance((int value) -> System.out.println("Sp1 before: " + value));

        var sp2 = sp1.trySplit();
        sp1.tryAdvance((int value) -> System.out.println("Sp1: " + value));
        sp2.tryAdvance((int value) -> System.out.println("Sp2: " + value));
    }
}
