package org.mj.module1.lesson1;

public class Aliasing {
    public static void main(String[] args) {
        // primitives

        int x = 99;
        int y = x;
        System.out.println(x);
        System.out.println(y);

        // changing one of them
        y = 100;
        System.out.println(x);
        System.out.println(y);

        System.out.println("-------------------------------------");

        // refrence types

        String s1 = "Hello";
        String s2 = s1;
        System.out.println(s1);
        System.out.println(s2);

        // changing one of them
        s2 = s2.concat(" World!");
        System.out.println(s1);
        System.out.println(s2);

        System.out.println("-------------------------------------");

        // Trying again with StringBuilders
        StringBuilder sb1 = new StringBuilder("Hello");
        StringBuilder sb2 = sb1; // aliases
        System.out.println(sb1);
        System.out.println(sb2);

        sb2.append(" World!"); // changing one of them
        System.out.println(sb1);
        System.out.println(sb2);
    }
}
