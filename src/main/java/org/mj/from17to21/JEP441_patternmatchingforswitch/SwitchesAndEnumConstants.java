package org.mj.from17to21.JEP441_patternmatchingforswitch;

sealed interface CardClassification permits Suit, Tarot {}
enum Suit implements CardClassification { CLUBS, DIAMONDS, HEARTS, SPADES }
final class Tarot implements CardClassification {}

public class SwitchesAndEnumConstants {
    public static void main(String[] args) {
        Suit s = Suit.HEARTS;
        Tarot t = new Tarot();

        testForHeartsAndDiamonds(s);
        testForHeartsAndDiamonds(Suit.DIAMONDS);
        System.out.println("-----------------------");
        exhaustiveSwitchWithoutEnumSupport(s);
        exhaustiveSwitchWithoutEnumSupport(t);
        System.out.println("-----------------------");
        exhaustiveSwitchWithBetterEnumSupport(s);
        exhaustiveSwitchWithBetterEnumSupport(t);
    }

    static void testForHeartsAndDiamonds(Suit s) {
        switch (s) {
            case HEARTS -> System.out.println("It's a heart!");
            // fully qualified enum case labels were not allowed before Java 21.
            // Now this is relaxed and both qualified and unqualified labels are allowed in one switch.
            // BUT FOR THIS THE selector expression should be of the enum type if it is parent of enum,
            // then compilation will fail, only fully qualified enum case labels will be allowed.
            case Suit.DIAMONDS -> System.out.println("It's a diamond!");
            default -> System.out.println("Some other suit");
        }
    }

    static void testForHeartsAndDiamonds2(CardClassification s) {
        // Here the selector is of a parent type of enum, so only fully qualified case labels allowed.
        switch (s) {
            case Suit.HEARTS -> System.out.println("It's a heart!");
            case Suit.DIAMONDS -> System.out.println("It's a diamond!");
            //case SPADES -> {} // This will be comp error
            default -> System.out.println("Some other suit");
        }
    }

    // This can be used with enums but now case labels with fully qualified enum case labels are allowed
    static void exhaustiveSwitchWithoutEnumSupport(CardClassification c) {
        switch (c) {
            case Suit s when s == Suit.CLUBS -> {
                System.out.println("It's clubs");
            }
            case Suit s when s == Suit.DIAMONDS -> {
                System.out.println("It's diamonds");
            }
            case Suit s when s == Suit.HEARTS -> {
                System.out.println("It's hearts");
            }
            case Suit s -> {
                System.out.println("It's spades");
            }
            case Tarot t -> {
                System.out.println("It's a tarot");
            }
        }
    }

    // As of Java 21
    static void exhaustiveSwitchWithBetterEnumSupport(CardClassification c) {
        // Again, only fully qualified enum case labels will be allowed
        switch (c) {
            case Suit.CLUBS -> {
                System.out.println("It's clubs");
            }
            case Suit.DIAMONDS -> {
                System.out.println("It's diamonds");
            }
            case Suit.HEARTS -> {
                System.out.println("It's hearts");
            }
            case Suit.SPADES -> {
                System.out.println("It's spades");
            }
            case Tarot t -> {
                System.out.println("It's a tarot");
            }
        }
    }

}
