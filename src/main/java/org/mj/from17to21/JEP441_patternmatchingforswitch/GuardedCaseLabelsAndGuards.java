package org.mj.from17to21.JEP441_patternmatchingforswitch;

public class GuardedCaseLabelsAndGuards {
    public static void main(String[] args) {
        String yes = "YES", no = "NO", maybe = "MAYBE";

        testStringOld(yes);
        testStringOld(no);
        testStringOld(maybe);
        System.out.println("-----------------------");
        testStringNew(yes);
        testStringNew(no);
        testStringNew(maybe);
        System.out.println("-----------------------");
        testStringEnhanced(yes);
        testStringEnhanced(no);
        testStringEnhanced(maybe);
        testStringEnhanced(null);
        testStringEnhanced("y");
        testStringEnhanced("n");
    }

    // As of Java 21, 'if' tests required to refine the cases
    static void testStringOld(String response) {
        switch (response) {
            case null -> {
            }
            case String s -> {
                if (s.equalsIgnoreCase("YES"))
                    System.out.println("You got it");
                else if (s.equalsIgnoreCase("NO"))
                    System.out.println("Shame");
                else
                    System.out.println("Sorry?");
            }
        }
    }

    // As of Java 21, refinement is done in case itself with introduction of Guarded case labels and Guards.
    // The case label which have a when clause is called a guarded case label.
    // The boolean condition after 'when' is called the guard.
    static void testStringNew(String response) {
        switch (response) {
            case null -> {
            }
            // Here 'String s when s.equalsIgnoreCase("YES")' is the guarded case label
            // 's.equalsIgnoreCase("YES")' is the guard, the guard may/may not contain the pattern variable 's'
            case String s
                    when s.equalsIgnoreCase("YES") -> {
                System.out.println("You got it");
            }
            case String s
                    when s.equalsIgnoreCase("NO") -> {
                System.out.println("Shame");
            }
            case String s -> {
                System.out.println("Sorry?");
            }
        }
    }

    // As of Java 21
    static void testStringEnhanced(String response) {

        // Observe all combinations of case labels
        switch (response) {
            case null -> { }
            case "y", "Y" -> {
                System.out.println("You got it");
            }
            case "n", "N" -> {
                System.out.println("Shame");
            }
            case String s
                    when s.equalsIgnoreCase("YES") -> {
                System.out.println("You got it");
            }
            case String s
                    when s.equalsIgnoreCase("NO") -> {
                System.out.println("Shame");
            }
            case String s -> {
                System.out.println("Sorry?");
            }
        }
    }
}
