package org.mj.from21to25.JEP485_streamgatherers;

import java.time.Duration;
import java.time.Instant;
import java.util.List;
import java.util.Optional;
import java.util.stream.Gatherers;

public class Gatherer1 {
    public static void main(String[] args) {
        List<String> names = List.of("MJ", "SS", "AG", "RJ");
        names.stream().gather(Gatherers.windowFixed(2)).forEach(System.out::println);
        System.out.println("=========");

        names.stream().gather(Gatherers.windowSliding(5)).forEach(System.out::println);
        System.out.println("=========");

        Optional<String> numberString =
                names.stream().gather(Gatherers.fold(() -> "", (string1, string2) -> string1 + string2))
                        .findFirst();
        System.out.println(numberString.get());

        System.out.println("=========");
        names.stream().gather(Gatherers.scan(() -> "", (string1, string2) -> string1 + string2))
                .forEach(System.out::println);

        System.out.println("=========");
        // Performance improvement with gatherers.

        // Stream elements processed in single thread, slower.
        Instant start = Instant.now();
        names.stream().map((string1 -> {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return string1 + "Something";
        })).forEach(System.out::println);
        Instant end = Instant.now();
        System.out.println(Duration.between(start, end).toMillis());

        System.out.println("=========");

        // Stream elements processed in multiple Virtual thread, faster
        start = Instant.now();
        names.stream().gather(Gatherers.mapConcurrent(10, string1 -> {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    return string1 + "Something";
                }))
                .forEach(System.out::println);
        end = Instant.now();
        System.out.println(Duration.between(start, end).toMillis());
    }
}
