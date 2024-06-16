package org.mj.module2.lesson4;

public class SwitchExpressionExample {
    public static void main(String[] args) {
        int x = 0;

        // Simple form
        switch (x) {
            case 0 -> System.out.println("Zero");
        }

        // Expression form
        var res = switch (x/* +1 */) {
            case 0 -> "Zero";
            default -> throw new IllegalArgumentException("Bad Value!"); // In expression form we need to address all possible values, do default here is needed
        }; // Needs Semi-colon in this case
        System.out.println(res);

        enum Suit {
            HEART, CLUB, SPADE, DIAMOND
        }
        Suit s = Suit.HEART;

        var res2 = switch (s) {
            case CLUB -> "Clubs";
            case HEART -> "Hearts";
            case SPADE -> "Spades";
            case DIAMOND -> "Diamonds";   // No need of default here as we are addressing all possible values
        };
        System.out.println(res2);

        System.out.println("-----------Passing a switch expression as an argument-----------");
        System.out.println("The Ace is: "+ switch (s) {
            case CLUB -> "Clubs";
            case HEART -> "Hearts";
            case SPADE -> "Spades";
            case DIAMOND -> "Diamonds";   // No need of default here
        });
    }
}
