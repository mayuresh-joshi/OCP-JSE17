package org.mj.module2.lesson4;

import java.util.List;

public class FundamentalsOfFlowControl {
    public static void main(String[] args) {

        for (int i = 0, j = 1; i < 3; i++, j++) {
            System.out.println(j);
        }

        //String in for loop iniitialization is allowed are also allowed

        // Print index : name
        List<String> names = List.of("MJ", "SS", "AG");
        for (String n : names) {
            System.out.println(names.indexOf(n) + " : " + n);
        }

        for (int i = 0; i < 3; i++) {
            System.out.println(i++);
            continue;
            //i++; //if this is uncommented compilation fails. Reason: this is unreachable statement

        }

        // Lables

        talkative:
        System.out.println("Label on a statement");

        blockOne:
        {
            System.out.println("Label on a block");
        }

        // lables with same name allowed Compiles OK
        blockOne:
        {
            System.out.println("Label on a block");
            //blockOne: {} // not allowed
        }

        //block2: { block2: {}} //Not allowed, same label name not allowed in the scope of another label

        //block: block: {} // Same as sbove

        block:
        {
            int block = 1; // allowed
            //block: {} // not allowed
        }

        int blockOne = 0;

        //myLoop: while(true) {int myLoop = 0;}  // COmpiles ok but runs forever

        final int x = 10;
        int y = 20; // change to final and see magic
        while (x > y)
            System.out.println("hello");
    }
}
