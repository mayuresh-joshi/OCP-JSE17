package org.mj.module3.lesson9;

public class StaticFieldInitialization {
    static {
        //text = "hello";
        //System.out.println(text); // Unqualified forward reference is illegal, comp error, even if you initialize just before the access.
        System.out.println(StaticFieldInitialization.text); // Qualified forward reference is allowed, but returns uninitialized value
    }

    static String text = "Some Text";
    public static void main(String[] args) {


    }
}
