package org.mj.misctopics.mathapi;

public class MathAPIExamples {
    public static void main(String[] args) {

        // constants present as fields
        System.out.println(Math.E);
        System.out.println(Math.PI);
        System.out.println("====================");

        // general functions
        System.out.println(Math.sqrt(100d));
        System.out.println(Math.cbrt(1000d));
        System.out.println(Math.pow(10, 2));
        System.out.println(Math.max(2, 10));
        System.out.println(Math.abs(-10));
        System.out.println(Math.floor(9.9));
        System.out.println(Math.ceil(9.9));
        System.out.println("====================");

        // trigonometric functions
        System.out.println(Math.sin(Math.toRadians(90)));
        System.out.println(Math.cos(Math.toRadians(0)));
        System.out.println(Math.tan(Math.toRadians(45)));

        // There are many more functions that do mathematical operation while considering overflows
        // Post-fixed with word 'Exact'
        // Ref - https://docs.oracle.com/javase/8/docs/api/?java/lang/Math.html
    }
}
