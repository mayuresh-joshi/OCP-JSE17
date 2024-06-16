package org.mj.module2.lesson4;

public class ArrowFormOfSwitch {
    public static void main(String[] args) {

        // 'Fall through' issue with tradition 'colon' form of switch. NO BREAKS!
        int i = 99;
        switch (i) {
            case 97, 98, 99:
                System.out.println("99");
            case 100:
                System.out.println("100");
            default:
                System.out.println("Other");   // Default is optional if switch is not being used as an expression
        }

        System.out.println("---------------------------");

        // Arrow form of switch, does not have 'fall through' issue.
        switch (i) {
            case 97, 98, 99 -> System.out.println("99");
            case 100 -> {
                int x = 10;  // Declaration allowed inside block
                System.out.println("100");
                System.out.println("100");
            }
            //case 101 -> int y =10; // Declaration Not allowed without a block
            //case 102 -> // This is not allowed
            //case 102 -> ; // This is not allowed
            case 103 -> {
            } // Empty block allowed
            default -> System.out.println("Other");
        }

    }
}
