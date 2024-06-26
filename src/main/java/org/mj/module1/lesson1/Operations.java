package org.mj.module1.lesson1;

public class Operations {
    public static void main(String[] args) {

        int i = +10; // unary +
        int j = -10; // unary -
        int k = ~10; // bit wise inversion operator
        int l = 10<<1;
        int m = 10>>1;
        boolean test1 = "A String" instanceof String;
        Object o = Integer.valueOf(10);
        boolean test2 = o instanceof String;
        int n;
        System.out.println(i);
        System.out.println(j);
        System.out.println(k);
        System.out.println(l);
        System.out.println(m);
        System.out.println(test1);
        System.out.println(test2);
        System.out.println(n = 10); // Assignments in Java has values
        //System.out.println(++n++); Does not compile , after ++n, the L-value is gone, means storage is gone. "To have Side effects you need to have L-values"

        // Day 2
        System.out.println("------------Day 2------------");
        System.out.println(7%3);
        System.out.println(7%-3); // % operator (remainder) takes sign from left hand operand and ignores the sign of right hand operand

        String S1 = "Hello";
        String S2 = "Hello";
        String S3 = new String("Hello");
        System.out.println(S1 == S2); // true
        System.out.println(S1 == S3); //false

    }
}
