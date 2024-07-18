package org.mj.module4.lesson16;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Generics {
    public static void main(String[] args) {

        List<String> listString = new ArrayList<>(/*List.of(LocalDate.of(1997, 9, 19))*/);
        List<String> listString2 = new ArrayList<>(List.<String>of("Mj")); // new for me but allowed
    }
}
