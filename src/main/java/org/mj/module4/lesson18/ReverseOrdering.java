package org.mj.module4.lesson18;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ReverseOrdering {

    // Comparator decoration
    public static <E> Comparator<E> backwardsComparator(Comparator<E> forward) {
        return (a, b) -> forward.compare(b, a);
    }

    public static void main(String[] args) {
        List<String> names = new ArrayList<>(List.of("MJ", "SS", "AG", "AP", "PB"));
        System.out.println(names);
        names.sort(String.CASE_INSENSITIVE_ORDER);
        System.out.println(names);
        names.sort(backwardsComparator(String.CASE_INSENSITIVE_ORDER));
        System.out.println(names);
    }
}
