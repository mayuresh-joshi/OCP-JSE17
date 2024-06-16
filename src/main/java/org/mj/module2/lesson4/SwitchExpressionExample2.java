package org.mj.module2.lesson4;

public class SwitchExpressionExample2 {
    public static void main(String[] args) {

        int x = 0;
        // Expression form with arrow
        var res = switch (x) {
            case 0 -> "Zero";
            default -> throw new IllegalArgumentException("Bad Value!");
        }; // Needs Semi-colon in this case
        System.out.println(res);

        // Expression form with arrow and blocks
        var res2 = switch (x) {
            case 0 -> {
                System.out.println("Calculating for x...");
                // This is not allowed, return is used to return a value and go out from a 'method/function', but here we are in a switch expression.
                //return "Zero";
                yield "Zero"; // yields is used inside expressions to return some value
            }//; // semicolon here is not permitted
            //case 1 -> yield "One"; // yield not allowed outside block, compilation error
            default -> throw new IllegalArgumentException("Bad Value!");
        }; // Needs Semi-colon in this case
        System.out.println(res2);

        // Expression form with colon (Remember this will have fall through without yield)
        var res3 = switch (x) {
            case 0:
                System.out.println("Calculating for x...");
                yield "Zero"; // yields is used inside expressions to return some value
            default:
                throw new IllegalArgumentException("Bad Value!");
        }; // Needs Semi-colon in this case
        System.out.println(res3);

        // All the below declarations are allowed. WOW!
        int yield = 0;
        int record = 1;
    }
}
