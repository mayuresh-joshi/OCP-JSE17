package org.mj.from17to21.JEP431_sequencedcollections;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SequencedCollections {

    public static void main(String[] args) {
        System.out.println("==========================");
        sequencedCollection();
        System.out.println("==========================");
        sequencedSet();
        System.out.println("==========================");
        sequencedMap();
    }

    private static void sequencedCollection() {
        List<String> sc = Stream.of("Alpha", "Bravo", "Charlie", "Delta").collect(Collectors.toCollection(ArrayList::new));
        System.out.println("Initial list: " + sc);
        System.out.println("Reversed list: " + sc.reversed());
        System.out.println("First item: " + sc.getFirst());
        System.out.println("Last item: " + sc.getLast());
        sc.addFirst("Before Alpha");
        sc.addLast("After Delta");
        System.out.println("Added new first and last item: " + sc);
    }

    private static void sequencedSet() {
        SortedSet<String> sortedSet = new TreeSet<>(Set.of("Charlie", "Alpha", "Delta", "Bravo"));
        System.out.println("Initial set: " + sortedSet);
        System.out.println("Reversed set: " + sortedSet.reversed());
        System.out.println("First item: " + sortedSet.getFirst());
        System.out.println("Last item: " + sortedSet.getLast());
        try {
            sortedSet.addFirst("Before Alpha");
        } catch (UnsupportedOperationException uoe) {
            System.out.println("addFirst is not supported in SortedSet");
        }
        try {
            sortedSet.addLast("After Delta");
        } catch (UnsupportedOperationException uoe) {
            System.out.println("addLast is not supported in SortedSet");
        }
    }

    private static void sequencedMap() {
        LinkedHashMap<Integer,String> hm = new LinkedHashMap<Integer,String>();
        hm.put(1, "Alpha");
        hm.put(2, "Bravo");
        hm.put(3, "Charlie");
        hm.put(4, "Delta");
        System.out.println("== Initial List ==");
        System.out.println(hm);
        System.out.println("== Reversed List ==");
        System.out.println(hm.reversed());
        System.out.println("First item: " + hm.firstEntry());
        System.out.println("Last item: " + hm.lastEntry());
        System.out.println(" == Added new first and last item ==");
        hm.putFirst(5, "Before Alpha");
        hm.putLast(3, "After Delta");
        System.out.println(hm);
    }
}
