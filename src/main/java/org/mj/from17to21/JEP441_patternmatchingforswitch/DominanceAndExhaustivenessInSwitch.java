package org.mj.from17to21.JEP441_patternmatchingforswitch;

public class DominanceAndExhaustivenessInSwitch {
    public static void main(String[] args) {

    }

    // As of Java 21, All good no dominance!
    static void first(Object obj) {
        switch (obj) {
            case String s ->
                    System.out.println("A string: " + s);
            case CharSequence cs ->
                    System.out.println("A sequence of length " + cs.length());
            default -> {
                break;
            }
        }
    }

    // As of Java 21, Dominance example
    static void error(Object obj) {
        switch (obj) {
            case CharSequence cs -> System.out.println("A sequence of length " + cs.length());
            // Error - pattern is dominated by previous pattern, String case is unreachable.
            // case String s ->  System.out.println("A string: " + s);   // Uncomment and observe the error
            default -> {
                break;
            }
        }
    }

    // Uncomment and carefully observe examples of these dominances as well.
    // In general if a case label makes any of its succeeding case label unreachable,
    // it is said to be dominating them, and it is a compilation error.
    // As of Java 21
    /*static void matchAll(String s) {
        switch(s) {
            case String t:
                System.out.println(t);
                break;
            default:
                System.out.println("Something else");  // Error - dominated!
        }
    }

    static void matchAll2(String s) {
        switch(s) {
            case Object o:
                System.out.println("An Object");
                break;
            default:
                System.out.println("Something else");  // Error - dominated!
        }
    }*/

    // *******************************************************************
    // Exhaustiveness and Switch
    // *******************************************************************

    // As of Java 21, Uncomment and observe the error of switch not covering all cases.
    /*static int coverage1(Object obj) {
        return switch (obj) {           // Error - not exhaustive
            case String s -> s.length();
        };
    }

    static int coverage2(Object obj) {
        return switch (obj) {           // Error - still not exhaustive
            case String s  -> s.length();
            case Integer i -> i;
        };
    }*/

    static int coverage3(Object obj) {
        return switch (obj) {           // Finally exhaustive
            case String s  -> s.length();
            case Integer i -> i;
            default -> 0; // Use default case to make a switch exhaustive, otherwise comp error
        };
    }

    // No point but legal
    static int coverage4(Object obj) {
        return switch (obj) {           // Finally exhaustive
            default -> 0; // Use default case to make a switch exhaustive, otherwise comp error
        };
    }

    // Same rules apply to enum switch cases as well, they should handle all values of enums,
    // either by writing cases for all enum values OR by providing default.

    // Special case - Exhaustiveness and sealed classes
    // When the selector expression if of a sealed type
    // and All permitted class/interfaces/records cases are present.
    // Then default can be skipped.
    // Here selector is of type 'S' which permits A, B, C and cases for all is present
    // So all possible values of selector are covered and this is exhaustive.
    // Hence, no default label required
    static int testSealedExhaustive(S s) {
        return switch (s) {
            case A a -> 1;
            case B b -> 2;
            case C c -> 3;
        };
    }
}

// As of Java 21
sealed interface S permits A, B, C {}
final class A implements S {}
final class B implements S {}
record C(int i) implements S {}    // Implicitly final
