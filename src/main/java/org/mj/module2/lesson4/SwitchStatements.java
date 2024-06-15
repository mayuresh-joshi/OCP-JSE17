package org.mj.module2.lesson4;

public class SwitchStatements {
    public static void main(String[] args) {

        final String s = "Hello";
        final String t = "Hello";
        final String u = "Hello1";

        switch (s) {
            case t:
                System.out.println("Hello");
                break;
            case u:
                System.out.println("Hello1");
                break;
            default:
                break;
        }
        return;
        //System.out.println("hello"); // compilation fails
    }

}
