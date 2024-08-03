package org.mj.module4.lesson18;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

class Student {
    String name;
    int percent;

    public Student(String name, int percent) {
        this.percent = percent;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getPercent() {
        return percent;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", percent=" + percent +
                '}';
    }
}

public class OrderingWithComparatorDecorations {
    public static void main(String[] args) {
        List<Student> roaster = new ArrayList<>(
                List.of(
                        new Student("MJ", 99),
                        new Student("SS", 80),
                        new Student("AG", 45),
                        new Student("AP", 68),
                        new Student("AG", 76),
                        new Student("RJ", 88)
                )
        );

        System.out.println("Original Order");
        roaster.forEach(System.out::println);

        System.out.println("Grade Order");
        roaster.sort(Comparator.comparingInt(s -> s.getPercent()));
        roaster.forEach(System.out::println);

        System.out.println("Name Order");
        roaster.sort(Comparator.comparing(s -> s.getName()));
        roaster.forEach(System.out::println);

        System.out.println("Name, and then Grade Order");
        roaster.sort(Comparator.comparing((Student s) -> s.getName())
                .thenComparing(s -> s.getPercent(), Comparator.reverseOrder()));
        roaster.forEach(System.out::println);
    }
}
