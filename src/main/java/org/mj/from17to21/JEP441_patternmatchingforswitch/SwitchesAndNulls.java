package org.mj.from17to21.JEP441_patternmatchingforswitch;

public class SwitchesAndNulls {
    public static void main(String[] args) {
        String s1 = "Foo", s2 = "Not Foo";

        testFooBarOld(s1);
        testFooBarOld(s2);
        testFooBarOld(null);
        System.out.println("-----------------------");
        testFooBarNew(s1);
        testFooBarNew(s2);
        testFooBarNew(null);
    }

    // Prior to Java 21, null check before switching otherwise NPE is thrown if selector expression is null
    static void testFooBarOld(String s) {
        if (s == null) {
            System.out.println("Oops!");
            return;
        }
        switch (s) {
            case "Foo", "Bar" -> System.out.println("Great");
            default           -> System.out.println("Ok");
        }
    }

    // As of Java 21, a new 'null' case lable introduced to handle null selector value
    static void testFooBarNew(String s) {
        switch (s) {
            case null         -> System.out.println("Oops!");
            case "Foo", "Bar" -> System.out.println("Great");
            default           -> System.out.println("Ok");
        }
    }
}
