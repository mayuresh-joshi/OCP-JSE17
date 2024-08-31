package org.mj.module8.lesson30;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Walk {
    public static void main(String[] args) throws IOException {
        Files.walk(Path.of("src/main/java"))
                //.forEach(System.out::println);
                .forEach(s -> System.out.println(s.normalize().toAbsolutePath()));

        System.out.println("-----------------------------------------------");

        // find method allows filtering. Depth limit available for both walk and find
        Files.find(Path.of("src/main/java"), 3, (p, a) -> a.isDirectory())
                .forEach(System.out::println);
    }
}
