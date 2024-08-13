package org.mj.module5.lesson21;

import java.util.List;
import java.util.stream.Collectors;

public class SimpleCollection {
    public static void main(String[] args) {
        List.of("Mayuresh", "Darshan", "Sharvari", "Vaibhav", "Pramod", "Praveen", "Abhijit")
                .stream()
                .collect(Collectors.groupingBy(s -> s.length()))
                .forEach((k, v) -> System.out.printf("%d character words are %s\n", k, v));

        System.out.println("--------------");

        List.of("Mayuresh", "Darshan", "Sharvari", "Vaibhav", "Pramod", "Praveen", "Abhijit")
                .stream()
                .collect(Collectors.partitioningBy(s -> s.length()> 7))
                .entrySet()
                .forEach(System.out::println);
    }
}
