package org.mj.module1.lesson2;

public class StringIdentity {
    public static void main(String[] args) {
        String s1 = "Hello";
        String s2 = "Hello";

        // constant
        final String s3 = "He"; // remove final and check result.
        String s4 = s3 + "llo";

        // non constant
        String s5 = "He";
        String s6 = s5 + "llo";

        System.out.println("s1 == s2? " + (s1 == s2));
        System.out.println("s1 == s4? " + (s1 == s4));

        System.out.println("s1 == s6? " + (s1 == s6));
        s6 = s6.intern();
        System.out.println("s1 == s6? " + (s1 == s6));

    }
}
