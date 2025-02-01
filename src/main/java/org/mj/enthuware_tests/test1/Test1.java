package org.mj.enthuware_tests.test1;

import java.text.NumberFormat;
import java.time.*;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Test1 {
    public static void main(String[] args) {
        //1
        System.out.println("Current Locale: " + Locale.getDefault());
        Locale.setDefault(Locale.ITALY);
        System.out.println("Current Locale: " + Locale.getDefault());
        Locale.setDefault(Locale.Category.DISPLAY, Locale.CHINA);
        System.out.println("Current Locale: " + Locale.getDefault());

        Stream<String> ss = Stream.of("Pizza", "Bread", "Tofu", "Pizza", "Tofu", "Cheese", "Pizza");
        Map<String, Long> data = ss.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        data.keySet().stream().sorted().parallel().forEachOrdered(key -> System.out.print(data.get(key)));

        //2
        try {
            if (false) return;
            else throw new Exception("Some Exception");
        } catch (Exception e) {
            System.out.println("Exception in Main");
        } finally {
            System.out.println("The end");
        }

        //3
        Float f1 = 10.0f;
        Float f2 = 0.0f;
        Float f3 = null;
        double f = 0.0;
        try {
            f = f1 / f2;
            System.out.println(Double.isInfinite(f));
            System.out.println(f);
            f3 = f1 / f2;
        } catch (Exception e) {
            System.out.println("Exception");
        }
        System.out.println(f3.isInfinite());


        //4
        Period p = Period.between(LocalDate.now(), LocalDate.of(2022, Month.SEPTEMBER, 1));
        System.out.println(p);
        Duration d = Duration.between(LocalTime.now(), LocalTime.of(0, 0, 0));
        System.out.println(d);

        //5
        double amount = 200_00.00;
        NumberFormat nf1 = NumberFormat.getCurrencyInstance(Locale.US);
        NumberFormat nf2 = NumberFormat.getCompactNumberInstance(Locale.US, NumberFormat.Style.SHORT);
        System.out.println(nf1.format(amount));
        System.out.println(nf2.format(amount));

        //6
        List<Integer> ls = Arrays.asList(1, 2, 3);
        //ls.stream().forEach(System.out::print).map(a -> a * 2).forEach(System.out::print);

        //7
        int i = 0, j = 11;
        do {
            if (i > j) {
                break;
            }
            j--;
        } while (++i < 5);
        System.out.println(i + "  " + j);

        //8
        java.time.LocalDate dt = java.time.LocalDate.parse("2015-01-01")
                .minusMonths(1).minusDays(1).plusYears(1);
        System.out.println(dt);
    }
}
