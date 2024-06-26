package org.mj.module3.lesson8;

public class StaticFieldCornerCase {

    // If this block is moved below count declaration the both qualified and unqualified access to count is permitted
    // THis behaviour is same for instance fields and instance initializers
    static {
        System.out.println("Value of count is: " + StaticFieldCornerCase.count); // qualified form of access for count
        //System.out.println("Value of count is: " + count); // Forward referencing without an unqualified form is not allowed
        count = 99;
    }

    static int count;

    public static void main(String[] args) {
        int y;
        //System.out.println(y); // using a local variable without initializing it is compilation error
    }

    static {
        System.out.println("Count is now: " + count);
    }
}
